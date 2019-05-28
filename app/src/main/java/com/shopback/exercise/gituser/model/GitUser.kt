package com.shopback.exercise.gituser.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Ricky on 2019-05-28.
 */
data class GitUser(
        @SerializedName("avatar_url")
        val avatarURL: String,

        val bio: Any,
        val blog: String,
        val company: Any,

        @SerializedName("created_at")
        val createdAt: String,

        val email: Any,

        @SerializedName("events_url")
        val eventsURL: String,

        val followers: Int,

        @SerializedName("followers_url")
        val followersURL: String,
        val following: Int,

        @SerializedName("following_url")
        val followingURL: String,

        @SerializedName("gists_url")
        val gistsURL: String,

        @SerializedName("gravatar_id")
        val gravatarId: String,

        val hireable: Any,

        @SerializedName("html_url")
        val htmlURL: String,

        val id: Int,
        val location: String,
        val login: String,
        val name: String,

        @SerializedName("node_id")
        val nodeId: String,

        @SerializedName("organizations_url")
        val organizationsURL: String,

        @SerializedName("public_gists")
        val publicGists: Int,

        @SerializedName("public_repos")
        val publicRepos: Int,

        @SerializedName("received_events_url")
        val receivedEventsURL: String,

        @SerializedName("repos_url")
        val reposURL: String,

        @SerializedName("site_admin")
        val siteAdmin: Boolean,

        @SerializedName("starred_url")
        val starredURL: String,

        @SerializedName("subscriptions_url")
        val subscriptionsURL: String,

        val type: String,

        @SerializedName("updated_at")
        val updatedAt: String,

        val url: String
)