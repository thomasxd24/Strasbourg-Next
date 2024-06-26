package eu.strasbourg.portlet.link.action;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;

import eu.strasbourg.service.link.model.Link;
import eu.strasbourg.service.link.service.LinkLocalService;
import eu.strasbourg.utils.constants.StrasbourgPortletKeys;

@Component(
	immediate = true,
	property = { "javax.portlet.name=" + StrasbourgPortletKeys.LINK_BO,
		"mvc.command.name=selectionAction" },
	service = MVCActionCommand.class)
public class SelectionActionCommand implements MVCActionCommand {

	@Override
	public boolean processAction(ActionRequest actionRequest,
		ActionResponse actionResponse) throws PortletException {
		String tab = ParamUtil.getString(actionRequest, "tab");

		try {
			long[] selectionIds = ParamUtil.getLongValues(actionRequest, "rowIds");
			for (long entryId : selectionIds) {
				switch (ParamUtil.getString(actionRequest, "cmd")) {
				case "delete":
					if (tab.equals("links")) {
						_linkLocalService.removeLink(entryId);
					}
					break;
				case "publish":
					if (tab.equals("links")) {
						Link link = _linkLocalService.getLink(entryId);
						_linkLocalService.updateStatus(link, WorkflowConstants.STATUS_APPROVED);
					}
					break;
				case "unpublish":
					if (tab.equals("links")) {
						Link link = _linkLocalService.getLink(entryId);
						_linkLocalService.updateStatus(link, WorkflowConstants.STATUS_DRAFT);
					}
					break;
				}
			}
		} catch (PortalException e) {
			_log.error(e);
		}
		return false;
	}

	private LinkLocalService _linkLocalService;

	@Reference(unbind = "-")
	protected void setLinkLocalService(LinkLocalService linkLocalService) {

		_linkLocalService = linkLocalService;
	}

	private final Log _log = LogFactoryUtil.getLog(this.getClass().getName());
}
