package eu.strasbourg.portlet.notification.action;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;

import eu.strasbourg.service.notification.model.Notification;
import eu.strasbourg.service.notification.service.NotificationLocalService;
import eu.strasbourg.utils.constants.StrasbourgPortletKeys;

@Component(immediate = true, property = { "javax.portlet.name=" + StrasbourgPortletKeys.NOTIFICATION_BO,
		"mvc.command.name=selectionAction" }, service = MVCActionCommand.class)
public class SelectionActionCommand implements MVCActionCommand {

	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {
		String tab = ParamUtil.getString(actionRequest, "tab");

		long[] selectionIds = ParamUtil.getLongValues(actionRequest, "rowIds");

		for (long entryId : selectionIds) {
			try {
				switch (ParamUtil.getString(actionRequest, "cmd")) {
				case "delete":
					if (tab.equals("notifications")) {
						_notificationLocalService.removeNotification(entryId);
					}
					break;
				case "publish":
					if (tab.equals("notifications")) {
						Notification notification = _notificationLocalService.getNotification(entryId);
						_notificationLocalService.updateStatus(notification, WorkflowConstants.STATUS_APPROVED);
					}
					break;
				case "unpublish":
					if (tab.equals("notifications")) {
						Notification notification = _notificationLocalService.getNotification(entryId);
						_notificationLocalService.updateStatus(notification, WorkflowConstants.STATUS_DRAFT);
					}
					break;
				}
			} catch (PortalException e) {
				_log.error(e);
			}
		}

		// Redirection (évite double
		// requête POST si l'utilisateur actualise sa page)
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String portletName = (String) actionRequest.getAttribute(WebKeys.PORTLET_ID);
		PortletURL renderUrl = PortletURLFactoryUtil.create(actionRequest, portletName, themeDisplay.getPlid(),
				PortletRequest.RENDER_PHASE);
		try {
			actionResponse.sendRedirect(renderUrl.toString());
		} catch (Exception ex) {
			_log.error(ex);
		}
		return false;
	}

	private NotificationLocalService _notificationLocalService;

	@Reference(unbind = "-")
	protected void setNotificationLocalService(NotificationLocalService notificationLocalService) {

		_notificationLocalService = notificationLocalService;
	}

	private final Log _log = LogFactoryUtil.getLog(this.getClass().getName());
}
