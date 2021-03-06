package org.spotify4j.models;

import java.util.Optional;
import java.util.regex.Pattern;


/**
 * The unique string identifying the Spotify user that you can find at the
 * end of the Spotify URI for the user. The ID of the current user can be
 * obtained via the Web API endpoint https://api.spotify.com/v1/me.
 **/
public class SpotifyUserId {
    private final String spotifyUserId;
    private static final Pattern PATTERN = Pattern.compile("^[a-zA-Z0-9]+");

    protected SpotifyUserId(String spotifyUserId) {
        this.spotifyUserId = spotifyUserId;
    }

    public static Optional<SpotifyUserId> verify(String spotifyUserId) {
        return PATTERN.matcher(spotifyUserId).matches() ?
                Optional.of(new SpotifyUserId(spotifyUserId)) :
                Optional.empty();
    }

    public String getSpotifyUserId() {
        return spotifyUserId;
    }
}
