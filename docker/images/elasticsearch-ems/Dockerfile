FROM elasticsearch:8.10.4

ENV ES_PATH=/usr/share/elasticsearch

USER root

RUN $ES_PATH/bin/elasticsearch-plugin install analysis-icu \
    && $ES_PATH/bin/elasticsearch-plugin install analysis-kuromoji \
    && $ES_PATH/bin/elasticsearch-plugin install analysis-smartcn \
    && $ES_PATH/bin/elasticsearch-plugin install analysis-stempel

USER elasticsearch

EXPOSE 9200 9300