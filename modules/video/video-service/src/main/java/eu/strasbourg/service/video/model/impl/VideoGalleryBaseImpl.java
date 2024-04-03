/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.video.model.impl;

import eu.strasbourg.service.video.model.VideoGallery;
import eu.strasbourg.service.video.service.VideoGalleryLocalServiceUtil;

/**
 * The extended model base implementation for the VideoGallery service. Represents a row in the &quot;video_VideoGallery&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link VideoGalleryImpl}.
 * </p>
 *
 * @author BenjaminBini
 * @see VideoGalleryImpl
 * @see VideoGallery
 * @generated
 */
public abstract class VideoGalleryBaseImpl
	extends VideoGalleryModelImpl implements VideoGallery {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a video gallery model instance should use the <code>VideoGallery</code> interface instead.
	 */
	@Override
	public void persist() {
		if (this.isNew()) {
			VideoGalleryLocalServiceUtil.addVideoGallery(this);
		}
		else {
			VideoGalleryLocalServiceUtil.updateVideoGallery(this);
		}
	}

}