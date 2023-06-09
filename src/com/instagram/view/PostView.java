package com.instagram.view;

import com.instagram.controller.PostController;
import com.instagram.model.User;
import com.instagram.model.Post;
import com.instagram.view.validation.UserValidation;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

/**
 * Represents the posts, posted by user
 *
 * @author Arun
 * @version 1.1
 */

public class PostView {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final PostController POST_CONTROLLER = new PostController();
    private static final UserView USER_VIEW = new UserView();
    private static final UserValidation USER_VALIDATION = new UserValidation() ;
    private static long id = 0;

    /**
     * Prints the post menu of the user.
     */
    public void postMenu(final User user) {
        System.out.println(String.join(" ","Click 1 To Create Post\nClick 2 To Display All Post",
                "\nClick 3 To Delete Post\nClick 4 To Update Post\nClick 5 To Display Single Post\nClick 6 To User",
                "Screen\nDo You Want To Continue Press 'Any Word' And Press 'No' For User Screen\nEnter Your Message:"));

        if (USER_VALIDATION.isExit(SCANNER.nextLine())) {
            USER_VIEW.userScreen(user);
        }

        switch (USER_VIEW.getChoice()) {
            case 1:
                createPost(user);
                break;
            case 2:
                displayAllPost(user);
                break;
            case 3:
                deletePost(user);
                break;
            case 4:
                updatePost(user);
                break;
            case 5:
                getPostById();
                postMenu(user);
                break;
            case 6:
                USER_VIEW.userScreen(user);
                break;
            default:
                System.out.println("Invalid User Choice. Please Enter The Choice In The Range[1-6]");
                postMenu(user);
                break;
        }
    }

    /**
     * Gets user location.
     *
     * @return The location of the user.
     */
    private String getLocation() {
        System.out.println("Enter Your Location Of Your Post:");

        return SCANNER.nextLine();
    }

    /**
     * Gets user caption.
     *
     * @return The caption of the user.
     */
    private String getCaption() {
        System.out.println("Enter Your Caption:");

        return SCANNER.nextLine();
    }

    /**
     * Creates the post of the user
     *
     * @param user The user object containing user details
     */
    private void createPost(final User user) {
        final Post post = new Post();

        getPostFormat(post);
        post.setId(++id);
        post.setLocation(getLocation());
        post.setCaption(getCaption());
        post.setTime(LocalTime.now());
        post.setDate(LocalDate.now());
        post.setUser(user);
        user.getPosts().add(post);

        System.out.println(POST_CONTROLLER.createPost(post) ? "User Posted Successfully" : "User Post Not Created");
        postMenu(user);
    }

    private void getPostFormat(final Post post) {
        System.out.println("Enter Post Format\nClick 1 To Image\nClick 2 To Video");

        switch (USER_VIEW.getChoice()) {
            case 1:
                post.setPostFormat(Post.PostFormat.IMAGE);
                break;
            case 2:
                post.setPostFormat(Post.PostFormat.VIDEO);
                break;
            default:
                System.out.println("Invalid User Choice.Please Enter 1 Or 2 To Get Post Format");
                getPostFormat(post);
                break;
        }
    }

    /**
     * Prints the all posts, posted by user
     *
     * @param user The user object containing user details
     */
    public void displayAllPost(final User user) {
        System.out.println(POST_CONTROLLER.getAllPost());
        postMenu(user);
    }

    /**
     * Gets the post detail of the user
     *
     * @return Represents {@link Post} user post
     */
    public Post getPostById() {
        System.out.println("Enter Your PostId:");
        final Post post = POST_CONTROLLER.getPostById(Long.parseLong(SCANNER.nextLine()));

        System.out.println(post);

        return post;
    }

    /**
     * Users to delete the post
     *
     * @param user The user object containing user details
     */
    public void deletePost(final User user) {
        System.out.println("Enter Your PostId:");
        System.out.println(POST_CONTROLLER.deletePost(Long.parseLong(SCANNER.nextLine())) ? "Post Deleted Successfully"
                : "Post Not Found");
        postMenu(user);
    }

    /**
     * Sets the details of the user post to update
     *
     * @param user The user object containing user details
     */
    private void updatePost(final User user) {
        System.out.println("Get The Post Of The User To Update Post Details");
        final Post post = new Post();
        final Post postDetail = getPostById();

        post.setLocation(USER_VIEW.exitAccess() ? postDetail.getLocation() : getLocation());
        post.setCaption(USER_VIEW.exitAccess() ? postDetail.getCaption() : getCaption());
        post.setTime(LocalTime.now());
        post.setDate(LocalDate.now());

        System.out.println(POST_CONTROLLER.updatePost(post) ? "User Post Updated Successfully" : "Post Not Updated");
        postMenu(user);
    }
}



