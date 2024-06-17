# Java Desktop Application for Mind Maps

This project represents a Java desktop application developed for a university subject called "Software Design". It serves as a platform for practicing various design patterns and follows the MVC (Model-View-Controller) architecture.

## Purpose

The purpose of this project is to create Mind Maps to aid in studying. Mind Maps provide a structured way to organize ideas and information, centered around a central topic with associations to different subtopics.

## Features

- **Project Management**: Users can create projects to group their Mind Maps.
- **Mind Map Creation**: Users can create Mind Maps.
- **Map Editing**: Users can edit the Mind Map by moving topics, editing colors and text.


## Design Patterns Used

- **Singleton**: Ensures that there is only one instance of certain classes, such as the application controller.
- **Observer**: Allows objects to subscribe to changes and be notified when changes occur, useful for updating the view when the model changes.
- **State Pattern**: Helps manage the state of the application, such as different states for creating, editing, or exporting maps.
- **Command Pattern**: Enables encapsulation of requests as objects, allowing for the parametrization of clients with queues, requests, and operations.
- **Composite Pattern**: Treats individual objects and compositions of objects uniformly, useful for representing topics and associations in the Mind Map.
- **Factory Method**: Provides an interface for creating objects, but allows subclasses to alter the type of objects that will be created, handy for creating different types of topics or associations.

