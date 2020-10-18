package com.usermanagement.system.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class User {
    int id;

    String login;

    @JsonProperty("node_id")
    String nodeID;

    @JsonProperty("avatar_url")
    String avatarURL;

    @JsonProperty("gravatar_id")
    String gravatarID;
    String url;

    @JsonProperty("html_url")
    String htmlURL;

    @JsonProperty("followers_url")
    String followerURL;

    @JsonProperty("following_url")
    String followingURL;

    @JsonProperty("gists_url")
    String gistURL;

    @JsonProperty("starred_url")
    String starredURL;

    @JsonProperty("subscriptions_url")
    String subscriptionURL;

    @JsonProperty("organizations_url")
    String organizationURL;

    @JsonProperty("repos_url")
    String repoURL;

    @JsonProperty("events_url")
    String eventURL;

    @JsonProperty("received_events_url")
    String receivedEventURL;

    String type;

    @JsonProperty("site_admin")
    boolean siteAdmin;

    @JsonProperty("name")
    String name;
    String company;
    String blog;
    String location;
    String email;
    String hireable;
    String bio;

    @JsonProperty("twitter_username")
    String twitterUsername;

    @JsonProperty("public_repos")
    String publicRepos;

    @JsonProperty("public_gists")
    String publicGists;

    String followers;
    String following;

    @JsonProperty("created_at")
    String createdAt;

    @JsonProperty("updated_at")
    String updatedAt;


    public User() {
    }



}
