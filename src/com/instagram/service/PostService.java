package com.instagram.service;

import com.instagram.model.Post;

import java.util.Collection;

/**
 * Provides post service for the user
 *
 * @author Arun
 * @version 1.1
 */
public interface PostService {

    /**
     * Creates the user post.
     *
     * @param post   The post detail of the user
     */
    boolean createPost(final Post post);

    /**
     * Gets the all post of the user
     *
     * @return The collection of post
     */
    Collection<Post> getAllPost();

    /**
     * Gets the post detail of the user
     *
     * @param id The post id of the user
     * @return The post details of the user
     */
    Post getPostById(final long id);

    /**
     * Deletes the user post
     *
     * @param id The post id of the user
     * @return True if post is deleted, false otherwise
     */
    boolean deletePost(final long id);

    /**
     * Updates the user post details
     *
     * @param updatedPost The updated post of the user
     * @return True if post is updated, false otherwise
     */
    boolean updatePost(final Post updatedPost);
}
