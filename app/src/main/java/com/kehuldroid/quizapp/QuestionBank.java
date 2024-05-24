package com.kehuldroid.quizapp;

import java.util.ArrayList;
import java.util.List;

public class QuestionBank {
    private List<Question> questions;

    public QuestionBank() {
        questions = new ArrayList<>();
        // Add questions to the list
        questions.add(new Question("Which file is the entry point for an Android application?",
                new String[]{"activity_main.xml", "MainActivity.java", "AndroidManifest.xml", "build.gradle"
                        }, 2));
        questions.add(new Question("What is the use of the findViewById() method in Android?",
                new String[]{"To create a new view", "To find and return a view that was identified by the ID attribute", "To delete a view", " To hide a view"}, 1));

        questions.add(new Question("Which component is NOT part of the Android application architecture?",
                new String[]{"Activities", "Services", " Fragments", "Protocols"
                }, 3));
        questions.add(new Question("What is an Intent in Android?",
                new String[]{"An instruction to the operating system to do something", "message to pass data between different components of an application", "A background process", "A way to start a service"
                }, 1));
        questions.add(new Question("Which method is used to start an activity?",
                new String[]{"startService()", "start()", "startActivity()", "startIntent()"
                }, 2));
        questions.add(new Question("What is the purpose of the RecyclerView in Android?",
                new String[]{"To display a list of items that can be scrolled vertically or horizontally", "To manage database operations\n", "To handle network operations", "To display static data only"
                }, 0));
        questions.add(new Question("What is the function of the Gradle in Android development??",
                new String[]{"To compile the app source code", "To manage app dependencies", "To package the app into APK", "All of the above"
                }, 3));
        questions.add(new Question("Which layout is best for creating a UI with flexible, responsive design?",
                new String[]{"LinearLayout", "RelativeLayout", "ConstraintLayout", "FrameLayout"
                }, 2));
        questions.add(new Question("What is the Android SDK?",
                new String[]{"Software Development Kit for developing Android applications", "A set of tools to develop web applications", "An operating system for mobile devices", "A programming language"
                }, 0));
        questions.add(new Question("Which of the following is NOT a lifecycle method of an Android activity?",
                new String[]{"onCreate()", "onStart()", "onResume()", "onDestroyView()"
                }, 3));

    }

    public List<Question> getQuestions() {
        return questions;
    }
}
