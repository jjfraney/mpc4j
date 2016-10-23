package org.jjfflyboy.mpc4j;

import java.time.ZonedDateTime;
import java.util.*;

/**
 * @author jfraney
 */
public class Count extends Simple {

    interface Type extends Criteria.Type {
    }

    private final Criteria criteria;
    private final Tag group;

    public Count(Count.Type type, String needle) {
        Map<Count.Type, String> map = new HashMap<>();
        map.put(type,needle);
        criteria = new Criteria(map);
        group = null;
    }
    public Count(Map<Count.Type, String> map) {
        criteria = new Criteria(map);
        group = null;
    }

    public Count(Count.Type type, String needle, Tag group) {
        Map<Count.Type, String> map = new HashMap<>();
        map.put(type,needle);
        criteria = new Criteria(map);
        this.group = group;
    }
    public Count(Map<Count.Type, String> map, Tag group) {
        criteria = new Criteria(map);
        this.group = group;
    }

    @Override
    public String text() {
        StringBuilder sb = new StringBuilder()
                .append("count ")
                .append(criteria.toParameters());
        if(group != null) {
            sb.append(" group ").append(group.toParameter());
        }
        return sb.toString();
    }

    @Override
    public Response response(String[] responseLines) {
        return new Response(responseLines);
    }

    public class Response extends Simple.Response {
        Response(String[] responseLines) {
            super(responseLines);
        }

        /**
         * @return if group was not specified, empty Optional, else the value for the 'songs' responseline.
         */
        public Optional<Integer> getSongs() {
            if(group != null) {
                return Optional.empty();
            } else {
              return getIntegerValue("songs");
            }
        }
        /**
         * @return if group was not specified, empty Optional, else the value for the 'songs' responseline.
         */
        public Optional<Integer> getPlaytime() {
            if(group != null) {
                return Optional.empty();
            } else {
                return getIntegerValue("playtime");
            }
        }

        public class Group extends ResponseContent {
            /**
             * @param responseLines limited to a single group
             */
            public Group(String[] responseLines) {
                super(responseLines);
            }

            public Optional<Integer> getSongs() {
                return getIntegerValue("songs");
            }

            public Optional<Integer> getPlaytime() {
                return getIntegerValue("playtime");
            }

            public Optional<String> getTag(Tag tag) {
                return getStringValue(tag.toSongLabel());
            }
        }

        /**
         * @return if group not specified, empty list, else groups of response lines as Group.
         */
        public List<Group> getGroups() {
            if(group == null) {
                return Collections.emptyList();
            } else {
                return getSubResponse(Group.class);
            }
        }
    }
}
