/**
 * Copyright 2000-present Liferay, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package eu.strasbourg.portlet.agenda.action;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import eu.strasbourg.service.agenda.model.Event;
import eu.strasbourg.service.agenda.model.Manifestation;
import eu.strasbourg.service.agenda.service.EventLocalService;
import eu.strasbourg.utils.constants.StrasbourgPortletKeys;

@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + StrasbourgPortletKeys.AGENDA_BO,
		"mvc.command.name=saveEvent" },
	service = MVCActionCommand.class)
public class SaveEventActionCommand
	implements MVCActionCommand {
	
	@Override
	public boolean processAction(ActionRequest request, ActionResponse response)
		throws PortletException {

		try {
			ServiceContext sc = ServiceContextFactory.getInstance(request);
			sc.setScopeGroupId(((ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY)).getCompanyGroupId());
			long eventId = ParamUtil.getLong(request, "eventId");
			Event event;
			if (eventId == 0) {
				event = _eventLocalService.createEvent(sc);
			} else {
				event = _eventLocalService.getEvent(eventId);
			}
			
			Map<Locale, String> title = LocalizationUtil
				.getLocalizationMap(request, "title");
			event.setTitleMap(title);
			
			Long imageId = ParamUtil.getLong(request, "imageId");
			event.setImageId(imageId);
			
			Map<Locale, String> subtitle = LocalizationUtil
				.getLocalizationMap(request, "subtitle");
			event.setSubtitleMap(subtitle);

			Map<Locale, String> description = LocalizationUtil
				.getLocalizationMap(request, "description");
			event.setDescriptionMap(description);

			String displayDateString = ParamUtil.getString(request, "displayDate");
			Date displayDate = DateUtil.parseDate(displayDateString, request.getLocale());
			event.setDisplayDate(displayDate);
			
			List<Manifestation> oldManifestations = event.getManifestations();
			for (Manifestation manifestation : oldManifestations) {
				_eventLocalService.deleteManifestationEvent(manifestation.getManifestationId(), event);
			}
			long[] manifestationsIds = ParamUtil.getLongValues(request, "manifestationsIds");
			for (long manifestationId : manifestationsIds) {
				if (manifestationId > 0) {
					_eventLocalService.addManifestationEvent(manifestationId, event);
				}
			}
			
			_eventLocalService.updateEvent(event, sc);
		} catch (PortalException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return true;
	}

	private EventLocalService _eventLocalService;

	@Reference(unbind = "-")
	protected void setEventLocalService(
		EventLocalService eventLocalService) {

		_eventLocalService = eventLocalService;
	}

}