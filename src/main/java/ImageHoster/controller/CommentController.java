package ImageHoster.controller;

import ImageHoster.model.Comment;
import ImageHoster.model.Image;
import ImageHoster.model.User;
import ImageHoster.service.CommentService;
import ImageHoster.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Date;


@Controller
public class CommentController {

    @Autowired
    ImageService imageService;

    @Autowired
    CommentService commentService;

    @RequestMapping(value = "/image/{imageId}/{imageTitle}/comments", method = RequestMethod.POST)
    public String addComment(@PathVariable("imageId") int imageId, @PathVariable("imageTitle") String title, @RequestParam("comment") String commentText, Comment comment, HttpSession session) {
        User user = (User) session.getAttribute("loggeduser");
        Image image = imageService.getImage(imageId);
        comment.setText(commentText);
        comment.setCreatedDate(new Date());
        comment.setImage(image);
        comment.setUser(user);
        commentService.addComment(comment);
        return "redirect:/images/" + imageId + "/" + title;
    }


}
