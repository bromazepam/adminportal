package com.adminportal.controller;

import com.adminportal.service.BookService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class ResourceController {

    private final BookService bookService;

    public ResourceController(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping(value = "/api/v1/book/removeList", method = RequestMethod.POST)
    public String removeList(@RequestBody ArrayList<String> bookIdList, Model model) {
        for (String id : bookIdList) {
            String bookId = id.substring(8);
            bookService.removeOne(Long.parseLong(bookId));
        }
        return "delete success";
    }
}
