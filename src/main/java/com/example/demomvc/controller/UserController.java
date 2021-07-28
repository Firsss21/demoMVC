package com.example.demomvc.controller;

import com.example.demomvc.entity.TodoEntity;
import com.example.demomvc.entity.UserEntity;
import com.example.demomvc.model.Student;
import com.example.demomvc.model.Todo;
import com.example.demomvc.model.User;
import com.example.demomvc.service.TodoService;
import com.example.demomvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    TodoService todoService;
    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("users", userService.getAll());
        return "user/index";
    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("user", new UserEntity());
        return "user/create";
    }

    @PostMapping("/create")
    public String createUser(@Valid @ModelAttribute("user") UserEntity userEntity, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "user/create";
        }
        userService.registration(userEntity);
        return index(model);
    }

    @GetMapping("/{id}/delete")
    public String deleteUser(@PathVariable Long id, Model model) {
        userService.delete(id);
        return index(model);
    }
    @GetMapping("/{id}")
    public String getOneUser(@PathVariable Long id, Model model){
        model.addAttribute("user", userService.getOne(id));
        return "user/getOne";
    }
    @GetMapping("/{id}/update")
    public String updateUserForm(@PathVariable Long id, Model model) {
        model.addAttribute("user", userService.getOne(id));
        return "user/update";
    }
    @PostMapping("/{id}/update")
    public String updateUser(@PathVariable Long id, @Valid @ModelAttribute("user") User user, Model model) {
        userService.updateUser(id, user);
        return index(model);
    }
    @GetMapping("/{id}/task")
    public String getTodoList(@PathVariable Long id, Model model) {
        User user = userService.getOne(id);
        user.getTodoList().stream().forEach(e -> System.out.println(e));
        model.addAttribute("user", user);
        model.addAttribute("tasks", user.getTodoList());
        return "user/tasks";
    }
    @GetMapping("/{id}/task/create")
    public String createTodoForm(@PathVariable Long id, Model model){
        model.addAttribute("task", new TodoEntity());
        model.addAttribute("id", id);
        return "user/tasks/create";
    }
    @PostMapping("/{id}/task/create")
    public String createTodo(@Valid @ModelAttribute("task") TodoEntity todoEntity,
                             BindingResult result,
                             @PathVariable Long id,
                             Model model) {
        if (result.hasErrors()) {
            return id + "/task/create";
        }
        todoService.createTodo(todoEntity, id);
        return getTodoList(id, model);
    }

    @GetMapping("/{id}/task/{task_id}/complete")
    public String completeTodo(@PathVariable Long id, @PathVariable Long task_id,  Model model) {
        todoService.completeTodo(task_id);
        return "redirect:/user/{id}/task";
    }
    @GetMapping("/{id}/task/{task_id}/update")
    public String updateTodoForm(@PathVariable Long id, @PathVariable Long task_id, Model model) {
        User user = userService.getOne(id);
        model.addAttribute("user", user);
        Todo todo = todoService.getOneById(task_id);
        System.out.println(todo);
        model.addAttribute("task", todo);
        return "user/tasks/update";
    }
    @PostMapping("/{id}/task/{task_id}/update")
    public String updateTodo(@Valid @ModelAttribute("task") Todo todo, Model model) {
        todoService.updateTodo(todo);
        return getTodoList(todo.getUser().getId(), model);
    }
    @GetMapping("/{id}/task/{task_id}/delete")
    public String deleteTodo(@PathVariable Long id, @PathVariable Long task_id, Model model) {
        todoService.deleteTodo(task_id);
        return getTodoList(id, model);
    }

}
