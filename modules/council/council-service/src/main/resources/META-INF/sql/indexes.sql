create index IX_A71BB2ED on council_CouncilSession (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_5FDE10AF on council_CouncilSession (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_B528576C on council_Deliberation (councilSessionId);
create index IX_302FDFBC on council_Deliberation (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_6E65253E on council_Deliberation (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_263C73FD on council_Official (email[$COLUMN_LENGTH:75$]);
create index IX_E139471F on council_Official (groupId, isActive);
create index IX_C307D0A3 on council_Official (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_148223E5 on council_Official (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_4433A78E on council_Procuration (councilSessionId);
create index IX_BF3B2FDE on council_Procuration (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_AEA15E0 on council_Procuration (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_3B3675FB on council_Vote (deliberationId, officialId);
create index IX_15E7C222 on council_Vote (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_2D5E6924 on council_Vote (uuid_[$COLUMN_LENGTH:75$], groupId);