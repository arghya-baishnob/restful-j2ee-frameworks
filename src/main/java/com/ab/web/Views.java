package com.ab.web;

/**
 * Created by arghya on 11/12/2015.
 */
public final class Views {
    public static final String LOGIN = "login";
    public static final String HOME = "home";
    public static final String ERROR = "error";
    public static final String SIGN_UP = "signup";

    public static final class Types {
        private Types() {
        }

        public static final String TILES = "tiles";
        public static final String REDIRECT = "redirect";
        public static final String JSON = "json";
        public static final String STREAM = "stream";
    }
}
