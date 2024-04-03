/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.gtfs.service.persistence.impl;

import com.liferay.portal.kernel.dao.orm.ArgumentsResolver;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.spring.osgi.OSGiBeanProperties;

import eu.strasbourg.service.gtfs.model.CacheAlertJSONTable;
import eu.strasbourg.service.gtfs.model.impl.CacheAlertJSONImpl;
import eu.strasbourg.service.gtfs.model.impl.CacheAlertJSONModelImpl;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * The arguments resolver class for retrieving value from CacheAlertJSON.
 *
 * @author Cedric Henry
 * @generated
 */
@OSGiBeanProperties(
	property = {
		"class.name=eu.strasbourg.service.gtfs.model.impl.CacheAlertJSONImpl",
		"table.name=gtfs_CacheAlertJSON"
	},
	service = ArgumentsResolver.class
)
public class CacheAlertJSONModelArgumentsResolver implements ArgumentsResolver {

	@Override
	public Object[] getArguments(
		FinderPath finderPath, BaseModel<?> baseModel, boolean checkColumn,
		boolean original) {

		String[] columnNames = finderPath.getColumnNames();

		if ((columnNames == null) || (columnNames.length == 0)) {
			if (baseModel.isNew()) {
				return new Object[0];
			}

			return null;
		}

		CacheAlertJSONModelImpl cacheAlertJSONModelImpl =
			(CacheAlertJSONModelImpl)baseModel;

		long columnBitmask = cacheAlertJSONModelImpl.getColumnBitmask();

		if (!checkColumn || (columnBitmask == 0)) {
			return _getValue(cacheAlertJSONModelImpl, columnNames, original);
		}

		Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
			finderPath);

		if (finderPathColumnBitmask == null) {
			finderPathColumnBitmask = 0L;

			for (String columnName : columnNames) {
				finderPathColumnBitmask |=
					cacheAlertJSONModelImpl.getColumnBitmask(columnName);
			}

			_finderPathColumnBitmasksCache.put(
				finderPath, finderPathColumnBitmask);
		}

		if ((columnBitmask & finderPathColumnBitmask) != 0) {
			return _getValue(cacheAlertJSONModelImpl, columnNames, original);
		}

		return null;
	}

	@Override
	public String getClassName() {
		return CacheAlertJSONImpl.class.getName();
	}

	@Override
	public String getTableName() {
		return CacheAlertJSONTable.INSTANCE.getTableName();
	}

	private static Object[] _getValue(
		CacheAlertJSONModelImpl cacheAlertJSONModelImpl, String[] columnNames,
		boolean original) {

		Object[] arguments = new Object[columnNames.length];

		for (int i = 0; i < arguments.length; i++) {
			String columnName = columnNames[i];

			if (original) {
				arguments[i] = cacheAlertJSONModelImpl.getColumnOriginalValue(
					columnName);
			}
			else {
				arguments[i] = cacheAlertJSONModelImpl.getColumnValue(
					columnName);
			}
		}

		return arguments;
	}

	private static final Map<FinderPath, Long> _finderPathColumnBitmasksCache =
		new ConcurrentHashMap<>();

}