create table comment_Comment (
	uuid_ VARCHAR(75) null,
	commentId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	status INTEGER,
	statusByUserId LONG,
	statusByUserName VARCHAR(75) null,
	statusDate DATE null,
	comment_ VARCHAR(75) null,
	level INTEGER,
	assetEntryId LONG,
	publikId VARCHAR(75) null,
	parentCommentId LONG,
	urlProjectCommentaire VARCHAR(75) null
);

create table comment_Signalement (
	uuid_ VARCHAR(75) null,
	signalementId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	status INTEGER,
	statusByUserId LONG,
	statusByUserName VARCHAR(75) null,
	statusDate DATE null,
	commentId LONG
);