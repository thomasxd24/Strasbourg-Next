package eu.strasbourg.portlet.agenda.asset;
import java.util.Locale;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.liferay.asset.kernel.model.BaseJSPAssetRenderer;

import eu.strasbourg.service.agenda.model.Event;
import eu.strasbourg.utils.constants.StrasbourgPortletKeys;

public class EventAssetRenderer extends BaseJSPAssetRenderer<Event> {
	
	public static final String TYPE = "event";
	private Event _entry;
	
	public EventAssetRenderer(Event entry) {
		_entry = entry;
	}
	
	@Override
	public Event getAssetObject() {
		return _entry;
	}

	@Override
	public long getGroupId() {
		return _entry.getGroupId();
	}

	@Override
	public long getUserId() {
		return _entry.getUserId();
	}

	@Override
	public String getUserName() {
		return _entry.getUserName();
	}

	@Override
	public String getUuid() {
		return _entry.getUuid();
	}

	@Override
	public String getClassName() {
		return Event.class.getName();
	}

	@Override
	public long getClassPK() {
		return _entry.getEventId();
	}

	@Override
	public String getSummary(PortletRequest portletRequest,
		PortletResponse portletResponse) {
		if(portletRequest != null)
		{
			return _entry.getDescription(portletRequest.getLocale());
		}
		else {
			return _entry.getDescription(Locale.FRANCE);
		}
	}

	@Override
	public String getTitle(Locale locale) {
		return _entry.getTitle(locale);
	}
	
	@Override
	public String getJspPath(HttpServletRequest request, String template) {
		if (template.equals(TEMPLATE_ABSTRACT) ||
			template.equals(TEMPLATE_FULL_CONTENT)) {

			return "/event/asset/" + template + ".jsp";
		}
		else {
			return null;
		}
	}
	
	@Override
	public boolean include(HttpServletRequest request,
		HttpServletResponse response, String template) throws Exception {

		request.setAttribute("entry", this._entry);
		request.setAttribute("detailPortletName", StrasbourgPortletKeys.ENTITY_DETAIL_WEB);
		
		return super.include(request, response, template);
	}

	public Event getEvent() {
		return this._entry;
	}
	
}
