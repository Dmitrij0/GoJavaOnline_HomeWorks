package com.gojavaonline3.dlenchuk.module10.streams.downloader;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LinksExtractor {

    private static final String REGEXP_FIND_TAG = "(?i)<a([^>]+)>(.+?)</a>";
    private static final String REGEXP_FIND_LINK =  "\\s*(?i)href\\s*=\\s*(\\\"([^\"]*\\\")|'[^']*'|([^'\">\\s]+))";

    private final Pattern tagPattern = Pattern.compile(REGEXP_FIND_TAG);
    private final Pattern linkPattern = Pattern.compile(REGEXP_FIND_LINK);

    Set<Link> links = new HashSet<>();
    private final String htmlPage;
    private boolean extracted;

    public LinksExtractor(String htmlPage) {
        this.htmlPage = htmlPage;
    }

    public Set<Link> extractLinks() {
        if (!extracted) {
            Matcher tagMatcher = tagPattern.matcher(htmlPage);
            while (tagMatcher.find()) {
                Matcher linkMatcher = linkPattern.matcher(tagMatcher.group(1));
                if (linkMatcher.find())
                    links.add(new Link(linkMatcher.group(1).substring(1, linkMatcher.group(1).length() - 1), tagMatcher.group(2)));
            }
        }
        return links;
    }

    public class Link {

        private String link;
        private String linkText;

        public Link() {
        }

        public Link(String link, String linkText) {
            this.link = link;
            this.linkText = linkText;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }

        public String getLinkText() {
            return linkText;
        }

        public void setLinkText(String linkText) {
            this.linkText = linkText;
        }

        @Override
        public String toString() {
            return "\nLink{" +
                    "link='" + link + '\'' +
                    ", linkText='" + linkText + '\'' +
                    "}";
        }
    }

}
