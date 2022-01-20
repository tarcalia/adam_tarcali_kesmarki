package application.controller;

import application.service.InputService;
import org.springframework.stereotype.Controller;

import java.util.Arrays;

/**
 * Main controller for the application.
 */
@Controller
public class UserController {
    private boolean answer = true;
    private InputService inputService;
    private PostController postController;
    private PutController putController;
    private DeleteController deleteController;
    private GetController getController;

    public UserController(InputService inputService, PostController postController, PutController putController, DeleteController deleteController, GetController getController) {
        this.inputService = inputService;
        this.postController = postController;
        this.putController = putController;
        this.deleteController = deleteController;
        this.getController = getController;
    }

    public void startApplication() {
        showMainOptions();
        do {
            handleInput(inputService.getNumericInput());
            showMainOptions();
        } while (answer);

    }

    public void handleInput(Integer userAnswer) {
        switch (userAnswer) {
            case 1 -> {
                showQueryOptions();
                getController.getQuery(inputService.getNumericInput());
            }
            case 2 -> {
                showOptionsForElements();
                postController.uploadElement(inputService.getNumericInput());
            }
            case 3 -> {
                showOptionsForElements();
                putController.modifyElement(inputService.getNumericInput());
            }
            case 4 -> {
                showOptionsForElements();
                deleteController.deleteElement(inputService.getNumericInput());
            }
            case 5 -> {
                answer = false;
            }
        }
    }

    private void showMainOptions() {
        String[] options = {"Please select one of the options:",
                "1, make a query", "2, add element to database",
                "3, modify element from database", "4, delete an element from database",
                "5, quit"};
        Arrays.stream(options).forEach(System.out::println);
    }

    private void showOptionsForElements() {
        String[] options = {"Please select which element you would like to add/delete/modify:",
                "1, Person", "2, Address", "3, Contact", "4, Cancel"};
        Arrays.stream(options).forEach(System.out::println);
    }

    private void showQueryOptions() {
        String[] options = {"Please select which query you want to:",
                "1, Persons", "2, Addresses", "3, Contacts", "4, Search", "5, Cancel"};
        Arrays.stream(options).forEach(System.out::println);
    }
}
