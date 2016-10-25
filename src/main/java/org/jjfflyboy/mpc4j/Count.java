package org.jjfflyboy.mpc4j;

import java.util.*;

/**
 * @author jfraney
 */
public class Count extends Simple {

    /**
     * The domain for the TAG parameter of 'count' command.
     */
    interface Type extends Criteria.Type {
    }

    public static class Term extends Criteria.Term {

        protected Term(Criteria.Type type, String what) {
            super(type, what);
        }
    }

    private final Criteria criteria;
    private final Tag group;

    public Count(Count.Type type, String needle) {
        criteria = new Criteria(new Count.Term(type, needle));
        group = null;
    }
    public Count(List<Count.Term> terms) {
        criteria = new Criteria(terms);
        group = null;
    }
    public Count(Count.Term... terms) {
        criteria = new Criteria(terms);
        group = null;
    }

    public Count(Count.Type type, String needle, Tag group) {
        criteria = new Criteria(new Count.Term(type, needle));
        this.group = group;
    }
    public Count(List<Count.Term> terms, Tag group) {
        criteria = new Criteria(terms);
        this.group = group;
    }
    public Count(Count.Term[] terms, Tag group) {
        criteria = new Criteria(terms);
        this.group = group;
    }
    public Count(Tag group, Count.Term... terms) {
        this(terms, group);
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