/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.place.service.base;

import com.liferay.asset.kernel.service.persistence.AssetEntryPersistence;
import com.liferay.asset.link.service.persistence.AssetLinkPersistence;
import com.liferay.asset.kernel.service.persistence.AssetTagPersistence;
import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.service.BaseServiceImpl;
import com.liferay.portal.kernel.service.persistence.ClassNamePersistence;
import com.liferay.portal.kernel.service.persistence.UserPersistence;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import eu.strasbourg.service.place.model.Place;
import eu.strasbourg.service.place.service.PlaceService;
import eu.strasbourg.service.place.service.PlaceServiceUtil;
import eu.strasbourg.service.place.service.persistence.CsmapCacheJsonPersistence;
import eu.strasbourg.service.place.service.persistence.GoogleMyBusinessHistoricPersistence;
import eu.strasbourg.service.place.service.persistence.HistoricPersistence;
import eu.strasbourg.service.place.service.persistence.PeriodPersistence;
import eu.strasbourg.service.place.service.persistence.PlacePersistence;
import eu.strasbourg.service.place.service.persistence.PricePersistence;
import eu.strasbourg.service.place.service.persistence.PublicHolidayPersistence;
import eu.strasbourg.service.place.service.persistence.ScheduleExceptionPersistence;
import eu.strasbourg.service.place.service.persistence.SlotPersistence;
import eu.strasbourg.service.place.service.persistence.SubPlacePersistence;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the place remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link eu.strasbourg.service.place.service.impl.PlaceServiceImpl}.
 * </p>
 *
 * @author Angelique Zunino Champougny
 * @see eu.strasbourg.service.place.service.impl.PlaceServiceImpl
 * @generated
 */
public abstract class PlaceServiceBaseImpl
	extends BaseServiceImpl implements IdentifiableOSGiService, PlaceService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>PlaceService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>PlaceServiceUtil</code>.
	 */

	/**
	 * Returns the csmap cache json local service.
	 *
	 * @return the csmap cache json local service
	 */
	public eu.strasbourg.service.place.service.CsmapCacheJsonLocalService
		getCsmapCacheJsonLocalService() {

		return csmapCacheJsonLocalService;
	}

	/**
	 * Sets the csmap cache json local service.
	 *
	 * @param csmapCacheJsonLocalService the csmap cache json local service
	 */
	public void setCsmapCacheJsonLocalService(
		eu.strasbourg.service.place.service.CsmapCacheJsonLocalService
			csmapCacheJsonLocalService) {

		this.csmapCacheJsonLocalService = csmapCacheJsonLocalService;
	}

	/**
	 * Returns the csmap cache json persistence.
	 *
	 * @return the csmap cache json persistence
	 */
	public CsmapCacheJsonPersistence getCsmapCacheJsonPersistence() {
		return csmapCacheJsonPersistence;
	}

	/**
	 * Sets the csmap cache json persistence.
	 *
	 * @param csmapCacheJsonPersistence the csmap cache json persistence
	 */
	public void setCsmapCacheJsonPersistence(
		CsmapCacheJsonPersistence csmapCacheJsonPersistence) {

		this.csmapCacheJsonPersistence = csmapCacheJsonPersistence;
	}

	/**
	 * Returns the google my business historic local service.
	 *
	 * @return the google my business historic local service
	 */
	public
		eu.strasbourg.service.place.service.GoogleMyBusinessHistoricLocalService
			getGoogleMyBusinessHistoricLocalService() {

		return googleMyBusinessHistoricLocalService;
	}

	/**
	 * Sets the google my business historic local service.
	 *
	 * @param googleMyBusinessHistoricLocalService the google my business historic local service
	 */
	public void setGoogleMyBusinessHistoricLocalService(
		eu.strasbourg.service.place.service.GoogleMyBusinessHistoricLocalService
			googleMyBusinessHistoricLocalService) {

		this.googleMyBusinessHistoricLocalService =
			googleMyBusinessHistoricLocalService;
	}

	/**
	 * Returns the google my business historic persistence.
	 *
	 * @return the google my business historic persistence
	 */
	public GoogleMyBusinessHistoricPersistence
		getGoogleMyBusinessHistoricPersistence() {

		return googleMyBusinessHistoricPersistence;
	}

	/**
	 * Sets the google my business historic persistence.
	 *
	 * @param googleMyBusinessHistoricPersistence the google my business historic persistence
	 */
	public void setGoogleMyBusinessHistoricPersistence(
		GoogleMyBusinessHistoricPersistence
			googleMyBusinessHistoricPersistence) {

		this.googleMyBusinessHistoricPersistence =
			googleMyBusinessHistoricPersistence;
	}

	/**
	 * Returns the historic local service.
	 *
	 * @return the historic local service
	 */
	public eu.strasbourg.service.place.service.HistoricLocalService
		getHistoricLocalService() {

		return historicLocalService;
	}

	/**
	 * Sets the historic local service.
	 *
	 * @param historicLocalService the historic local service
	 */
	public void setHistoricLocalService(
		eu.strasbourg.service.place.service.HistoricLocalService
			historicLocalService) {

		this.historicLocalService = historicLocalService;
	}

	/**
	 * Returns the historic persistence.
	 *
	 * @return the historic persistence
	 */
	public HistoricPersistence getHistoricPersistence() {
		return historicPersistence;
	}

	/**
	 * Sets the historic persistence.
	 *
	 * @param historicPersistence the historic persistence
	 */
	public void setHistoricPersistence(
		HistoricPersistence historicPersistence) {

		this.historicPersistence = historicPersistence;
	}

	/**
	 * Returns the period local service.
	 *
	 * @return the period local service
	 */
	public eu.strasbourg.service.place.service.PeriodLocalService
		getPeriodLocalService() {

		return periodLocalService;
	}

	/**
	 * Sets the period local service.
	 *
	 * @param periodLocalService the period local service
	 */
	public void setPeriodLocalService(
		eu.strasbourg.service.place.service.PeriodLocalService
			periodLocalService) {

		this.periodLocalService = periodLocalService;
	}

	/**
	 * Returns the period persistence.
	 *
	 * @return the period persistence
	 */
	public PeriodPersistence getPeriodPersistence() {
		return periodPersistence;
	}

	/**
	 * Sets the period persistence.
	 *
	 * @param periodPersistence the period persistence
	 */
	public void setPeriodPersistence(PeriodPersistence periodPersistence) {
		this.periodPersistence = periodPersistence;
	}

	/**
	 * Returns the place local service.
	 *
	 * @return the place local service
	 */
	public eu.strasbourg.service.place.service.PlaceLocalService
		getPlaceLocalService() {

		return placeLocalService;
	}

	/**
	 * Sets the place local service.
	 *
	 * @param placeLocalService the place local service
	 */
	public void setPlaceLocalService(
		eu.strasbourg.service.place.service.PlaceLocalService
			placeLocalService) {

		this.placeLocalService = placeLocalService;
	}

	/**
	 * Returns the place remote service.
	 *
	 * @return the place remote service
	 */
	public PlaceService getPlaceService() {
		return placeService;
	}

	/**
	 * Sets the place remote service.
	 *
	 * @param placeService the place remote service
	 */
	public void setPlaceService(PlaceService placeService) {
		this.placeService = placeService;
	}

	/**
	 * Returns the place persistence.
	 *
	 * @return the place persistence
	 */
	public PlacePersistence getPlacePersistence() {
		return placePersistence;
	}

	/**
	 * Sets the place persistence.
	 *
	 * @param placePersistence the place persistence
	 */
	public void setPlacePersistence(PlacePersistence placePersistence) {
		this.placePersistence = placePersistence;
	}

	/**
	 * Returns the price local service.
	 *
	 * @return the price local service
	 */
	public eu.strasbourg.service.place.service.PriceLocalService
		getPriceLocalService() {

		return priceLocalService;
	}

	/**
	 * Sets the price local service.
	 *
	 * @param priceLocalService the price local service
	 */
	public void setPriceLocalService(
		eu.strasbourg.service.place.service.PriceLocalService
			priceLocalService) {

		this.priceLocalService = priceLocalService;
	}

	/**
	 * Returns the price persistence.
	 *
	 * @return the price persistence
	 */
	public PricePersistence getPricePersistence() {
		return pricePersistence;
	}

	/**
	 * Sets the price persistence.
	 *
	 * @param pricePersistence the price persistence
	 */
	public void setPricePersistence(PricePersistence pricePersistence) {
		this.pricePersistence = pricePersistence;
	}

	/**
	 * Returns the public holiday local service.
	 *
	 * @return the public holiday local service
	 */
	public eu.strasbourg.service.place.service.PublicHolidayLocalService
		getPublicHolidayLocalService() {

		return publicHolidayLocalService;
	}

	/**
	 * Sets the public holiday local service.
	 *
	 * @param publicHolidayLocalService the public holiday local service
	 */
	public void setPublicHolidayLocalService(
		eu.strasbourg.service.place.service.PublicHolidayLocalService
			publicHolidayLocalService) {

		this.publicHolidayLocalService = publicHolidayLocalService;
	}

	/**
	 * Returns the public holiday persistence.
	 *
	 * @return the public holiday persistence
	 */
	public PublicHolidayPersistence getPublicHolidayPersistence() {
		return publicHolidayPersistence;
	}

	/**
	 * Sets the public holiday persistence.
	 *
	 * @param publicHolidayPersistence the public holiday persistence
	 */
	public void setPublicHolidayPersistence(
		PublicHolidayPersistence publicHolidayPersistence) {

		this.publicHolidayPersistence = publicHolidayPersistence;
	}

	/**
	 * Returns the schedule exception local service.
	 *
	 * @return the schedule exception local service
	 */
	public eu.strasbourg.service.place.service.ScheduleExceptionLocalService
		getScheduleExceptionLocalService() {

		return scheduleExceptionLocalService;
	}

	/**
	 * Sets the schedule exception local service.
	 *
	 * @param scheduleExceptionLocalService the schedule exception local service
	 */
	public void setScheduleExceptionLocalService(
		eu.strasbourg.service.place.service.ScheduleExceptionLocalService
			scheduleExceptionLocalService) {

		this.scheduleExceptionLocalService = scheduleExceptionLocalService;
	}

	/**
	 * Returns the schedule exception persistence.
	 *
	 * @return the schedule exception persistence
	 */
	public ScheduleExceptionPersistence getScheduleExceptionPersistence() {
		return scheduleExceptionPersistence;
	}

	/**
	 * Sets the schedule exception persistence.
	 *
	 * @param scheduleExceptionPersistence the schedule exception persistence
	 */
	public void setScheduleExceptionPersistence(
		ScheduleExceptionPersistence scheduleExceptionPersistence) {

		this.scheduleExceptionPersistence = scheduleExceptionPersistence;
	}

	/**
	 * Returns the slot local service.
	 *
	 * @return the slot local service
	 */
	public eu.strasbourg.service.place.service.SlotLocalService
		getSlotLocalService() {

		return slotLocalService;
	}

	/**
	 * Sets the slot local service.
	 *
	 * @param slotLocalService the slot local service
	 */
	public void setSlotLocalService(
		eu.strasbourg.service.place.service.SlotLocalService slotLocalService) {

		this.slotLocalService = slotLocalService;
	}

	/**
	 * Returns the slot persistence.
	 *
	 * @return the slot persistence
	 */
	public SlotPersistence getSlotPersistence() {
		return slotPersistence;
	}

	/**
	 * Sets the slot persistence.
	 *
	 * @param slotPersistence the slot persistence
	 */
	public void setSlotPersistence(SlotPersistence slotPersistence) {
		this.slotPersistence = slotPersistence;
	}

	/**
	 * Returns the sub place local service.
	 *
	 * @return the sub place local service
	 */
	public eu.strasbourg.service.place.service.SubPlaceLocalService
		getSubPlaceLocalService() {

		return subPlaceLocalService;
	}

	/**
	 * Sets the sub place local service.
	 *
	 * @param subPlaceLocalService the sub place local service
	 */
	public void setSubPlaceLocalService(
		eu.strasbourg.service.place.service.SubPlaceLocalService
			subPlaceLocalService) {

		this.subPlaceLocalService = subPlaceLocalService;
	}

	/**
	 * Returns the sub place persistence.
	 *
	 * @return the sub place persistence
	 */
	public SubPlacePersistence getSubPlacePersistence() {
		return subPlacePersistence;
	}

	/**
	 * Sets the sub place persistence.
	 *
	 * @param subPlacePersistence the sub place persistence
	 */
	public void setSubPlacePersistence(
		SubPlacePersistence subPlacePersistence) {

		this.subPlacePersistence = subPlacePersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.kernel.service.CounterLocalService
		getCounterLocalService() {

		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.kernel.service.CounterLocalService
			counterLocalService) {

		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the class name local service.
	 *
	 * @return the class name local service
	 */
	public com.liferay.portal.kernel.service.ClassNameLocalService
		getClassNameLocalService() {

		return classNameLocalService;
	}

	/**
	 * Sets the class name local service.
	 *
	 * @param classNameLocalService the class name local service
	 */
	public void setClassNameLocalService(
		com.liferay.portal.kernel.service.ClassNameLocalService
			classNameLocalService) {

		this.classNameLocalService = classNameLocalService;
	}

	/**
	 * Returns the class name remote service.
	 *
	 * @return the class name remote service
	 */
	public com.liferay.portal.kernel.service.ClassNameService
		getClassNameService() {

		return classNameService;
	}

	/**
	 * Sets the class name remote service.
	 *
	 * @param classNameService the class name remote service
	 */
	public void setClassNameService(
		com.liferay.portal.kernel.service.ClassNameService classNameService) {

		this.classNameService = classNameService;
	}

	/**
	 * Returns the class name persistence.
	 *
	 * @return the class name persistence
	 */
	public ClassNamePersistence getClassNamePersistence() {
		return classNamePersistence;
	}

	/**
	 * Sets the class name persistence.
	 *
	 * @param classNamePersistence the class name persistence
	 */
	public void setClassNamePersistence(
		ClassNamePersistence classNamePersistence) {

		this.classNamePersistence = classNamePersistence;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public com.liferay.portal.kernel.service.ResourceLocalService
		getResourceLocalService() {

		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.kernel.service.ResourceLocalService
			resourceLocalService) {

		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.kernel.service.UserLocalService
		getUserLocalService() {

		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.kernel.service.UserLocalService userLocalService) {

		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public com.liferay.portal.kernel.service.UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(
		com.liferay.portal.kernel.service.UserService userService) {

		this.userService = userService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	/**
	 * Returns the asset entry local service.
	 *
	 * @return the asset entry local service
	 */
	public com.liferay.asset.kernel.service.AssetEntryLocalService
		getAssetEntryLocalService() {

		return assetEntryLocalService;
	}

	/**
	 * Sets the asset entry local service.
	 *
	 * @param assetEntryLocalService the asset entry local service
	 */
	public void setAssetEntryLocalService(
		com.liferay.asset.kernel.service.AssetEntryLocalService
			assetEntryLocalService) {

		this.assetEntryLocalService = assetEntryLocalService;
	}

	/**
	 * Returns the asset entry remote service.
	 *
	 * @return the asset entry remote service
	 */
	public com.liferay.asset.kernel.service.AssetEntryService
		getAssetEntryService() {

		return assetEntryService;
	}

	/**
	 * Sets the asset entry remote service.
	 *
	 * @param assetEntryService the asset entry remote service
	 */
	public void setAssetEntryService(
		com.liferay.asset.kernel.service.AssetEntryService assetEntryService) {

		this.assetEntryService = assetEntryService;
	}

	/**
	 * Returns the asset entry persistence.
	 *
	 * @return the asset entry persistence
	 */
	public AssetEntryPersistence getAssetEntryPersistence() {
		return assetEntryPersistence;
	}

	/**
	 * Sets the asset entry persistence.
	 *
	 * @param assetEntryPersistence the asset entry persistence
	 */
	public void setAssetEntryPersistence(
		AssetEntryPersistence assetEntryPersistence) {

		this.assetEntryPersistence = assetEntryPersistence;
	}

	/**
	 * Returns the asset link local service.
	 *
	 * @return the asset link local service
	 */
	public com.liferay.asset.kernel.service.AssetLinkLocalService
		getAssetLinkLocalService() {

		return assetLinkLocalService;
	}

	/**
	 * Sets the asset link local service.
	 *
	 * @param assetLinkLocalService the asset link local service
	 */
	public void setAssetLinkLocalService(
		com.liferay.asset.kernel.service.AssetLinkLocalService
			assetLinkLocalService) {

		this.assetLinkLocalService = assetLinkLocalService;
	}

	/**
	 * Returns the asset link persistence.
	 *
	 * @return the asset link persistence
	 */
	public AssetLinkPersistence getAssetLinkPersistence() {
		return assetLinkPersistence;
	}

	/**
	 * Sets the asset link persistence.
	 *
	 * @param assetLinkPersistence the asset link persistence
	 */
	public void setAssetLinkPersistence(
		AssetLinkPersistence assetLinkPersistence) {

		this.assetLinkPersistence = assetLinkPersistence;
	}

	/**
	 * Returns the asset tag local service.
	 *
	 * @return the asset tag local service
	 */
	public com.liferay.asset.kernel.service.AssetTagLocalService
		getAssetTagLocalService() {

		return assetTagLocalService;
	}

	/**
	 * Sets the asset tag local service.
	 *
	 * @param assetTagLocalService the asset tag local service
	 */
	public void setAssetTagLocalService(
		com.liferay.asset.kernel.service.AssetTagLocalService
			assetTagLocalService) {

		this.assetTagLocalService = assetTagLocalService;
	}

	/**
	 * Returns the asset tag remote service.
	 *
	 * @return the asset tag remote service
	 */
	public com.liferay.asset.kernel.service.AssetTagService
		getAssetTagService() {

		return assetTagService;
	}

	/**
	 * Sets the asset tag remote service.
	 *
	 * @param assetTagService the asset tag remote service
	 */
	public void setAssetTagService(
		com.liferay.asset.kernel.service.AssetTagService assetTagService) {

		this.assetTagService = assetTagService;
	}

	/**
	 * Returns the asset tag persistence.
	 *
	 * @return the asset tag persistence
	 */
	public AssetTagPersistence getAssetTagPersistence() {
		return assetTagPersistence;
	}

	/**
	 * Sets the asset tag persistence.
	 *
	 * @param assetTagPersistence the asset tag persistence
	 */
	public void setAssetTagPersistence(
		AssetTagPersistence assetTagPersistence) {

		this.assetTagPersistence = assetTagPersistence;
	}

	public void afterPropertiesSet() {
		PlaceServiceUtil.setService(placeService);
	}

	public void destroy() {
		PlaceServiceUtil.setService(null);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return PlaceService.class.getName();
	}

	protected Class<?> getModelClass() {
		return Place.class;
	}

	protected String getModelClassName() {
		return Place.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = placePersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(
				dataSource, sql);

			sqlUpdate.update();
		}
		catch (Exception exception) {
			throw new SystemException(exception);
		}
	}

	@BeanReference(
		type = eu.strasbourg.service.place.service.CsmapCacheJsonLocalService.class
	)
	protected eu.strasbourg.service.place.service.CsmapCacheJsonLocalService
		csmapCacheJsonLocalService;

	@BeanReference(type = CsmapCacheJsonPersistence.class)
	protected CsmapCacheJsonPersistence csmapCacheJsonPersistence;

	@BeanReference(
		type = eu.strasbourg.service.place.service.GoogleMyBusinessHistoricLocalService.class
	)
	protected
		eu.strasbourg.service.place.service.GoogleMyBusinessHistoricLocalService
			googleMyBusinessHistoricLocalService;

	@BeanReference(type = GoogleMyBusinessHistoricPersistence.class)
	protected GoogleMyBusinessHistoricPersistence
		googleMyBusinessHistoricPersistence;

	@BeanReference(
		type = eu.strasbourg.service.place.service.HistoricLocalService.class
	)
	protected eu.strasbourg.service.place.service.HistoricLocalService
		historicLocalService;

	@BeanReference(type = HistoricPersistence.class)
	protected HistoricPersistence historicPersistence;

	@BeanReference(
		type = eu.strasbourg.service.place.service.PeriodLocalService.class
	)
	protected eu.strasbourg.service.place.service.PeriodLocalService
		periodLocalService;

	@BeanReference(type = PeriodPersistence.class)
	protected PeriodPersistence periodPersistence;

	@BeanReference(
		type = eu.strasbourg.service.place.service.PlaceLocalService.class
	)
	protected eu.strasbourg.service.place.service.PlaceLocalService
		placeLocalService;

	@BeanReference(type = PlaceService.class)
	protected PlaceService placeService;

	@BeanReference(type = PlacePersistence.class)
	protected PlacePersistence placePersistence;

	@BeanReference(
		type = eu.strasbourg.service.place.service.PriceLocalService.class
	)
	protected eu.strasbourg.service.place.service.PriceLocalService
		priceLocalService;

	@BeanReference(type = PricePersistence.class)
	protected PricePersistence pricePersistence;

	@BeanReference(
		type = eu.strasbourg.service.place.service.PublicHolidayLocalService.class
	)
	protected eu.strasbourg.service.place.service.PublicHolidayLocalService
		publicHolidayLocalService;

	@BeanReference(type = PublicHolidayPersistence.class)
	protected PublicHolidayPersistence publicHolidayPersistence;

	@BeanReference(
		type = eu.strasbourg.service.place.service.ScheduleExceptionLocalService.class
	)
	protected eu.strasbourg.service.place.service.ScheduleExceptionLocalService
		scheduleExceptionLocalService;

	@BeanReference(type = ScheduleExceptionPersistence.class)
	protected ScheduleExceptionPersistence scheduleExceptionPersistence;

	@BeanReference(
		type = eu.strasbourg.service.place.service.SlotLocalService.class
	)
	protected eu.strasbourg.service.place.service.SlotLocalService
		slotLocalService;

	@BeanReference(type = SlotPersistence.class)
	protected SlotPersistence slotPersistence;

	@BeanReference(
		type = eu.strasbourg.service.place.service.SubPlaceLocalService.class
	)
	protected eu.strasbourg.service.place.service.SubPlaceLocalService
		subPlaceLocalService;

	@BeanReference(type = SubPlacePersistence.class)
	protected SubPlacePersistence subPlacePersistence;

	@ServiceReference(
		type = com.liferay.counter.kernel.service.CounterLocalService.class
	)
	protected com.liferay.counter.kernel.service.CounterLocalService
		counterLocalService;

	@ServiceReference(
		type = com.liferay.portal.kernel.service.ClassNameLocalService.class
	)
	protected com.liferay.portal.kernel.service.ClassNameLocalService
		classNameLocalService;

	@ServiceReference(
		type = com.liferay.portal.kernel.service.ClassNameService.class
	)
	protected com.liferay.portal.kernel.service.ClassNameService
		classNameService;

	@ServiceReference(type = ClassNamePersistence.class)
	protected ClassNamePersistence classNamePersistence;

	@ServiceReference(
		type = com.liferay.portal.kernel.service.ResourceLocalService.class
	)
	protected com.liferay.portal.kernel.service.ResourceLocalService
		resourceLocalService;

	@ServiceReference(
		type = com.liferay.portal.kernel.service.UserLocalService.class
	)
	protected com.liferay.portal.kernel.service.UserLocalService
		userLocalService;

	@ServiceReference(
		type = com.liferay.portal.kernel.service.UserService.class
	)
	protected com.liferay.portal.kernel.service.UserService userService;

	@ServiceReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;

	@ServiceReference(
		type = com.liferay.asset.kernel.service.AssetEntryLocalService.class
	)
	protected com.liferay.asset.kernel.service.AssetEntryLocalService
		assetEntryLocalService;

	@ServiceReference(
		type = com.liferay.asset.kernel.service.AssetEntryService.class
	)
	protected com.liferay.asset.kernel.service.AssetEntryService
		assetEntryService;

	@ServiceReference(type = AssetEntryPersistence.class)
	protected AssetEntryPersistence assetEntryPersistence;

	@ServiceReference(
		type = com.liferay.asset.kernel.service.AssetLinkLocalService.class
	)
	protected com.liferay.asset.kernel.service.AssetLinkLocalService
		assetLinkLocalService;

	@ServiceReference(type = AssetLinkPersistence.class)
	protected AssetLinkPersistence assetLinkPersistence;

	@ServiceReference(
		type = com.liferay.asset.kernel.service.AssetTagLocalService.class
	)
	protected com.liferay.asset.kernel.service.AssetTagLocalService
		assetTagLocalService;

	@ServiceReference(
		type = com.liferay.asset.kernel.service.AssetTagService.class
	)
	protected com.liferay.asset.kernel.service.AssetTagService assetTagService;

	@ServiceReference(type = AssetTagPersistence.class)
	protected AssetTagPersistence assetTagPersistence;

	private static final Log _log = LogFactoryUtil.getLog(
		PlaceServiceBaseImpl.class);

}