package com.instagram.service.impl;

import com.instagram.model.Post;
import com.instagram.service.PostService;

import java.util.Collection;
import java.util.List;
import java.util.ArrayList;

/**
 * Implements the post service of the user
 *
 * @author Arun
 * @version 1.1
 */
public class PostServiceImpl implements PostService {

    private static final List<Post> POSTS = new ArrayList<>();

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean createPost(final Post post) {
        return POSTS.add(post);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Collection<Post> getAllPost() {
        return POSTS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Post getPostById(final long id) {

        for (int index = 0; index < POSTS.size(); index++) {

            if (POSTS.get(index).getId() == id) {
                return POSTS.get(index);
            }
        }

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean deletePost(final long id) {
        final Post post = getPostById(id);

        return post != null && POSTS.remove(post);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean updatePost(final Post updatedPost) {

        for (int index = 0; index < POSTS.size(); index++) {

            if (POSTS.get(index).getId() == updatedPost.getId()) {
                POSTS.set(index, updatedPost);
                return true;
            }
        }

        return false;
    }
}
