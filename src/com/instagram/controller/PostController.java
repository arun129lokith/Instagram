package com.instagram.controller;

import com.instagram.model.Post;
import com.instagram.service.PostService;
import com.instagram.service.impl.PostServiceImpl;

import java.util.Collection;

/**
 * Communicates with service provider and user
 */
public class PostController {

    private static final PostService POST_SERVICE = new PostServiceImpl();

    /**
     * Creates the user post.
     *
     * @param post The post detail of the user
     */
    public boolean createPost(final Post post) {
        return POST_SERVICE.createPost(post);
    }

    /**
     * Gets the all post of the user
     *
     * @return The collection of post
     */
    public Collection<Post> getAllPost() {
        return POST_SERVICE.getAllPost();
    }

    /**
     * Gets the post detail of the user
     *
     * @param id The post id of the user
     * @return The post details of the user
     */
    public Post getPostById(final long id) {
        return POST_SERVICE.getPostById(id);
    }

    /**
     * Deletes the user post
     *
     * @param id The post id of the user
     * @return True if post is deleted, false otherwise
     */
    public boolean deletePost(final long id) {
        return POST_SERVICE.deletePost(id);
    }

    /**
     * Updates the user post details
     *
     * @param updatedPost The post of the user
     * @return True if post is updated, false otherwise
     */
    public boolean updatePost(final Post updatedPost) {
        return POST_SERVICE.updatePost(updatedPost);
    }
}
