package eu.strasbourg.service.favorite.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public enum FavoriteType {
	PLACE(1, "PLACE", "eu.strasbourg.service.place.model.Place",true, true),
	EVENT(2, "EVENT", "eu.strasbourg.service.agenda.model.Event",true, true),
	VIDEO(3, "VIDEO", "eu.strasbourg.service.video.model.Video",false, true),
	EDITION(4, "EDITION", "eu.strasbourg.service.edition.model.Edition",false, true),
	IMAGE(5, "IMAGE", "com.liferay.document.library.kernel.model.DLFileEntry",false, true),
	NEWS(6, "NEWS", "com.liferay.journal.model.JournalArticle",false, true),
	ARTICLE(7, "ARTICLE", "com.liferay.journal.model.JournalArticle",false, true),
	PROCEDURE(8, "PROCEDURE", String.class.getName(),false, true),
	PAGE(9, "PAGE", "com.liferay.portal.kernel.model.Layout",false, true),
	ACTIVITY(10, "ACTIVITY", "eu.strasbourg.service.activity.model.Activity",false, true),
	COURSE(11, "COURSE", "eu.strasbourg.service.activity.model.ActivityCourse",false, true),
	MANIFESTATION(12,"MANIFESTATION", "eu.strasbourg.service.agenda.model.Manifestation",true, true),
	GALLERY(13,"GALLERY", "eu.strasbourg.service.edition.model.EditionGallery",false, true),
	ARRET(14,"ARRET", "eu.strasbourg.service.gtfs.model.Arret",true, true),
	SEARCH(101,"SEARCH", null, true, false),
	FILTER(102,"FILTER", null, true, false);


	private long id;
	private String name;
	private String favoriteClass;
	private boolean isLiferay;
	private boolean isCSMap;

	FavoriteType(int id, String name, String favoriteClass, boolean isCSMap, boolean isLiferay) {
		this.id = id;
		this.name = name;
		this.favoriteClass = favoriteClass;
		this.isCSMap = isCSMap;
		this.isLiferay = isLiferay;

	}

	public long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFavoriteClass() {
		return favoriteClass;
	}

	public void setFavoriteClass(String favoriteClass) {
		this.favoriteClass = favoriteClass;
	}

	public boolean getIsLiferay() {
		return isLiferay;
	}

	public void setIsLiferay(boolean isLiferay) {
		this.isLiferay = isLiferay;
	}

	public boolean getIsCSMap() {
		return isCSMap;
	}

	public void setIsCSMap(boolean isCSMap) {
		this.isCSMap = isCSMap;
	}

	public static FavoriteType get(long id) {
		for (FavoriteType e : values()) {
			if (e.getId() == id) {
				return e;
			}
		}
		return null;
	}
	
	public static List<FavoriteType> getAll() {
		List<FavoriteType> favoritesType = new ArrayList<FavoriteType>();
		for (FavoriteType e : values()) {
			favoritesType.add(e);
			}		
		return favoritesType;
	}

	public static List<Long>getAllIsLiferayIds(){
		List<FavoriteType> favoritesTypes = getAll();
		List<FavoriteType> favoritesTypesIsLiferay = new ArrayList<>(favoritesTypes.stream().filter(f -> f.getIsLiferay()).collect(Collectors.toList()));
		List<Long> favoritesTypeIsLiferayIds = new ArrayList<>();
		for(FavoriteType favoriteType : favoritesTypesIsLiferay){
			favoritesTypeIsLiferayIds.add(favoriteType.getId());
		}
		return favoritesTypeIsLiferayIds;
	}

	public static List<Long>getAllIsCSMapIds(){
		List<FavoriteType> favoritesTypes = getAll();
		List<FavoriteType> favoritesTypesIsCSMap = new ArrayList<>(favoritesTypes.stream().filter(f -> f.getIsCSMap()).collect(Collectors.toList()));
		List<Long> favoritesTypeIsCSMapIds = new ArrayList<>();
		for(FavoriteType favoriteType : favoritesTypesIsCSMap){
			favoritesTypeIsCSMapIds.add(favoriteType.getId());
		}
		return favoritesTypeIsCSMapIds;
	}
}
