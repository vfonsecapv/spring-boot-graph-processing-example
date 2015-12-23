package org.kbastani.web;

import org.kbastani.twitter.TwitterService;
import org.kbastani.twitter.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Provides a single REST endpoint for seeding users to crawl on Twitter. Automated
 * crawling of Twitter users requires three seed users as input.
 *
 * @author kbastani
 */
@RestController
@RequestMapping("v1")
public class ApiController {

    private final TwitterService twitterService;

    @Autowired
    public ApiController(TwitterService twitterService) {
        this.twitterService = twitterService;
    }

    @RequestMapping(path = "user/{screenName}", method = RequestMethod.GET)
    public User getTweetsForUser(@PathVariable("screenName") String screenName) {
        return twitterService.discoverUserByScreenName(screenName);
    }

}
