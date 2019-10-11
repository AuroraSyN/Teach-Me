package de.hsworms.inf3032.data.trees;

import java.util.Arrays;
import java.util.List;

//TODO QU_CONTENT

public class EnglishTree {

    public static final List<String> ENGLISH_TREE = Arrays.asList(
            "C++ Basics",
            "C++ Object Oriented",
            "Operating System",
            "Java Basics",
            "Java Advanced",
            "DSA Basics",
            "DSA Advanced",
            "Java 9"

    );

    public static final List<String> CS_ENGLISH_INTERVIEW_TREE = Arrays.asList(
            "Java Interview questions",
            "C++ Interview questions",
            "Operating System questions",
            "DSA Interview questions"
    );

    public static final List<String> MC_ENGLISH_INTERVIEW_TREE = Arrays.asList(
            "Android",
            "jQuery"
    );

    public static final String[] JQUERY_QUESTIONS = new String[]{
            "What is jQuery?",
            "What are the core features of jQuery?",
            "How will you make sure that DOM is ready using jQuery?",
            "How can you create an Object in JavaScript?",
            "How can you read properties of an Object in JavaScript?",
            "How can you create an Array in JavaScript?",
            "How to read elements of an array in JavaScript?",
            "What is a named function in JavaScript? How to define a named function?",
            "How many types of functions JavaScript supports?",
            "How can you get the type of arguments passed to a function?",
            "How can you get the total number of arguments passed to a function?",
            "How can you get the reference of a caller function inside a function?",
            "What are the valid scopes of a variable in JavaScript?",
            "Give an example of closure?",
    };

    public static final String[] JQUERY_QUESTIONS_A = new String[]{
            "jQuery is a fast and concise JavaScript Library created by John Resig in 2006 with a nice motto - Write less, do more. jQuery simplifies HTML document traversing, event handling, animating, and Ajax interactions for rapid web development. jQuery is a JavaScript toolkit designed to simplify various tasks by writing less code.",
            "\n" +
                    "\n" +
                    "Following is the list of important core features supported by jQuery −\n" +
                    "\n" +
                    "    DOM manipulation − The jQuery made it easy to select DOM elements, traverse them and modifying their content by using cross-browser open source selector engine called Sizzle.\n" +
                    "\n" +
                    "    Event handling − The jQuery offers an elegant way to capture a wide variety of events, such as a user clicking on a link, without the need to clutter the HTML code itself with event handlers.\n" +
                    "\n" +
                    "    AJAX Support − The jQuery helps you a lot to develop a responsive and feature-rich site using AJAX technology.\n" +
                    "\n" +
                    "    Animations − The jQuery comes with plenty of built-in animation effects which you can use in your websites.\n" +
                    "\n" +
                    "    Lightweight − The jQuery is very lightweight library - about 19KB in size ( Minified and gzipped ).\n" +
                    "\n" +
                    "    Cross Browser Support − The jQuery has cross-browser support, and works well in IE 6.0+, FF 2.0+, Safari 3.0+, Chrome and Opera 9.0+.\n" +
                    "\n" +
                    "    Latest Technology − The jQuery supports CSS3 selectors and basic XPath syntax.\n" +
                    "\n",
            "Use $(document).ready() function. Everything inside it will load as soon as the DOM is loaded and before the page contents are loaded.",
            "\n" +
                    "\n" +
                    "JavaScript supports Object concept very well. You can create an object using the object literal as follows −\n" +
                    "\n" +
                    "var emp = {\n" +
                    "   name: \"Zara\",\n" +
                    "   age: 10\n" +
                    "};\n" +
                    "\n",
            "\n" +
                    "\n" +
                    "JavaScript supports Object concept very well. You can create an object using the object literal as follows −\n" +
                    "\n" +
                    "var emp = {\n" +
                    "   name: \"Zara\",\n" +
                    "   age: 10\n" +
                    "};\n" +
                    "\n" +
                    "You can write and read properties of an object using the dot notation as follows −\n" +
                    "\n" +
                    "// Getting object properties\n" +
                    "emp.name  // ==> Zara\n" +
                    "emp.age   // ==> 10\n" +
                    "\n" +
                    "// Setting object properties\n" +
                    "emp.name = \"Daisy\"  // <== Daisy\n" +
                    "emp.age  =  20      // <== 20\n" +
                    "\n",
            "\n" +
                    "\n" +
                    "You can define arrays using the array literal as follows −\n" +
                    "\n" +
                    "var x = [];\n" +
                    "var y = [1, 2, 3, 4, 5];\n" +
                    "\n",
            "\n" +
                    "\n" +
                    "An array has a length property that is useful for iteration. We can read elements of an array as follows −\n" +
                    "\n" +
                    "var x = [1, 2, 3, 4, 5];\n" +
                    "\n" +
                    "for (var i = 0; i < x.length; i++) {\n" +
                    "   // Do something with x[i]\n" +
                    "}\n" +
                    "\n",
            "\n" +
                    "\n" +
                    "A named function has a name when it is defined. A named function can be defined using function keyword as follows −\n" +
                    "\n" +
                    "function named(){\n" +
                    "   // do some stuff here\n" +
                    "}\n" +
                    "\n",
            "\n" +
                    "\n" +
                    "Using typeof operator, we can get the type of arguments passed to a function. For example −\n" +
                    "\n" +
                    "function func(x){\n" +
                    "   console.log(typeof x, arguments.length);\n" +
                    "}\n" +
                    "\n" +
                    "func();                //==> \"undefined\", 0\n" +
                    "func(1);               //==> \"number\", 1\n" +
                    "func(\"1\", \"2\", \"3\");   //==> \"string\", 3\n" +
                    "\n",
            "\n" +
                    "\n" +
                    "Using typeof operator, we can get the type of arguments passed to a function. For example −\n" +
                    "\n" +
                    "function func(x){\n" +
                    "   console.log(typeof x, arguments.length);\n" +
                    "}\n" +
                    "\n" +
                    "func();                //==> \"undefined\", 0\n" +
                    "func(1);               //==> \"number\", 1\n" +
                    "func(\"1\", \"2\", \"3\");   //==> \"string\", 3\n" +
                    "\n",
            "\n" +
                    "\n" +
                    "Using arguments.length property, we can get the total number of arguments passed to a function. For example −\n" +
                    "\n" +
                    "function func(x){\n" +
                    "   console.log(typeof x, arguments.length);\n" +
                    "}\n" +
                    "\n" +
                    "func();                //==> \"undefined\", 0\n" +
                    "func(1);               //==> \"number\", 1\n" +
                    "func(\"1\", \"2\", \"3\");   //==> \"string\", 3\n" +
                    "\n",
            "\n" +
                    "\n" +
                    "The arguments object has a callee property, which refers to the function you're inside of. For example −\n" +
                    "\n" +
                    "function func() {\n" +
                    "   return arguments.callee; \n" +
                    "}\n" +
                    "\n" +
                    "func();                // ==> func\n" +
                    "\n",
            "\n" +
                    "\n" +
                    "The scope of a variable is the region of your program in which it is defined. JavaScript variable will have only two scopes.\n" +
                    "\n" +
                    "    Global Variables − A global variable has global scope which means it is visible everywhere in your JavaScript code.\n" +
                    "\n" +
                    "    Local Variables − A local variable will be visible only within a function where it is defined. Function parameters are always local to that function.\n" +
                    "\n",
            "\n" +
                    "\n" +
                    "Following example shows how the variable counter is visible within the create, increment, and print functions, but not outside of them −\n" +
                    "\n" +
                    "function create() {\n" +
                    "   var counter = 0;\n" +
                    "\t\n" +
                    "   return {\n" +
                    "      increment: function() {\n" +
                    "         counter++;\n" +
                    "      },\n" +
                    "  \n" +
                    "      print: function() {\n" +
                    "         console.log(counter);\n" +
                    "      }\n" +
                    "   }\n" +
                    "}\n" +
                    "\n" +
                    "var c = create();\n" +
                    "c.increment();\n" +
                    "c.print();     // ==> 1\n" +
                    "\n",
    };


    public static final String[] ANDROID_QUESTIONS = new String[] {
            "What is Android?",
            "Describe Android application Architecture?",
            "What is An Activity?",
            "What is the APK format?",
            "What is An Intent?",
            "What is an explicit Intent?",
            "What is an implicit Intent?",
            "What is ADB in android?",
            "Define the application resource file in android?",
            "How to launch an activity in android?",
            "What is fragment in android?",
            "What folders are impotent in android project?",
            "What is drawable folder in android?",
    };

    public static final String[] ANDROID_QUESTIONS_A = new String[] {
            "Android is a stack of software for mobile devices which includes an Operating System, \n" +
                    "middleware and some key applications. The application executes within its own process and its own instance of Dalvik Virtual Machine.",
            "<p>Android application architecture has the following components.They are as follows −</p>\n" +
                    "<p>Services − It will perform background functionalities</p>\n" +
                    "<p>Intent − It will perform the inter connection between activities and the data passing mechanism</p>\n" +
                    "<p>Resource Externalization − strings and graphics</p>\n" +
                    "<p>Notification − light,sound,icon,notification,dialog box,and toast</p>\n" +
                    "<p>Content Providers − It will share the data between applications</p>",
            "Activity performs actions on the screen.If you want to do any operations, we can do with activity",
            "The Android packaging key is compressed with classes,UI's, supportive assets and manifest.All files are compressed to a single file is called APK.",
            "It is connected to either the external world of application or internal world of application ,Such as, opening a pdf is an intent and connect to the web browser.etc.",
            "Android Explicit intent specifies the component to be invoked from activity. In other words, we can call another activity in android by explicit intent.",
            "Implicit Intent doesn't specifiy the component. In such case, intent provides information of available components provided by the system that is to be invoked.",
            "It is acts as bridge between emulator and IDE, it executes remote shell commands to run applications on an emulator",
            "JSON,XML bitmap.etc are application resources.You can injected these files to build process and can load them from the code.",
            "<p>Using with intent, we can launch an activity.</p>\n" +
                    "<pre class=\"prettyprint notranslate prettyprinted\" style=\"\"><span class=\"typ\">Intent</span><span class=\"pln\"> intent </span><span class=\"pun\">=</span><span class=\"pln\"> </span><span class=\"kwd\">new</span><span class=\"pln\"> </span><span class=\"typ\">Intent</span><span class=\"pun\">(</span><span class=\"kwd\">this</span><span class=\"pun\">,</span><span class=\"pln\"> </span><span class=\"typ\">MyTestActivity</span><span class=\"pun\">.</span><span class=\"kwd\">class</span><span class=\"pun\">);</span><span class=\"pln\">\n" +
                    "\n" +
                    "        startActivity</span><span class=\"pun\">(</span><span class=\"pln\">intent</span><span class=\"pun\">);</span></pre>",
            "Fragment is a piece of activity, if you want to do turn your application 360 degrees, you can do this by fragment.",
            "<p>AndroidManifest.xml</p>\n" +
                    "<p>build.xml</p>\n" +
                    "<p>bin/</p>\n" +
                    "<p>src/</p>\n" +
                    "<p>res/</p>\n" +
                    "<p>assets/</p>",
            "A compiled visual resource that can  used as a backgrounds,banners, icons,splash screen etc.",
    };

    public static final String[] JAVA_INERVIEW_QUESTIONS = new String[]{
            "What do you know about Java?",
            "What are the supported platforms by Java Programming Language?",
            "List any five features of Java?",
            "Why is Java Architectural Neutral?",
            "How Java enabled High Performance?",
            "Why Java is considered dynamic?",
            "List two Java IDE’s?",
            "List some Java keywords(unlike C, C++ keywords)?",
            "What do you mean by Object?",
            "Define class?",
            "What kind of variables a class can consist of?",
            "What is a Local Variable?",
            "What is a Instance Variable?",
            "What is a Class Variable?",
            "What is Singleton class?",
            "What do you mean by Constructor?",
            "List the three steps for creating an Object for a class?",
            "What is the default value of byte datatype in Java?",
            "What is the default value of float and double datatype in Java?",
            "When a byte datatype is used?",
            "What is a static variable?",
            "What do you mean by Access Modifier?",
            "What is protected access modifier?",
            "What do you mean by synchronized Non Access Modifier?",
            "According to Java Operator precedence, which operator is considered to be with highest precedence?",
            "Variables used in a switch statement can be used with which datatypes?",
            "When parseInt() method can be used?",
            "Why is String class considered immutable?",
            "Why is StringBuffer called mutable?",
            "What is the difference between StringBuffer and StringBuilder class?"
    };


    public static final String[] JAVA_INERVIEW_QUESTIONS_A = new String[]{
            "Java is a high-level programming language originally developed by Sun Microsystems and released in 1995. Java runs on a variety of platforms, such as Windows, Mac OS, and the various versions of UNIX.",
            "Java runs on a variety of platforms, such as Windows, Mac OS, and the various versions of UNIX/Linux like HP-Unix, Sun Solaris, Redhat Linux, Ubuntu, CentOS, etc.",
            "List any five features of Java?",
            "It’s compiler generates an architecture-neutral object file format, which makes the compiled code to be executable on many processors, with the presence of Java runtime system.",
            "Java uses Just-In-Time compiler to enable high performance. Just-In-Time compiler is a program that turns Java bytecode, which is a program that contains instructions that must be interpreted into instructions that can be sent directly to the processor.",
            "When Java is compiled, it is not compiled into platform specific machine, rather into platform independent byte code. This byte code is distributed over the web and interpreted by virtual Machine (JVM) on whichever platform it is being run.",
            "Netbeans, Eclipse, etc.",
            "Some Java keywords are import, super, finally, etc.",
            "Object is a runtime entity and it’s state is stored in fields and behavior is shown via methods. Methods operate on an object's internal state and serve as the primary mechanism for object-to-object communication.",
            "A class is a blue print from which individual objects are created. A class can contain fields and methods to describe the behavior of an object.",
            "A class consist of Local variable, instance variables and class variables.",
            "Variables defined inside methods, constructors or blocks are called local variables. The variable will be declared and initialized within the method and it will be destroyed when the method has completed.",
            "Instance variables are variables within a class but outside any method. These variables are instantiated when the class is loaded.",
            "These are variables declared with in a class, outside any method, with the static keyword.",
            "Singleton class control object creation, limiting the number to one but allowing the flexibility to create more objects if the situation changes.",
            "Constructor gets invoked when a new object is created. Every class has a constructor. If we do not explicitly write a constructor for a class the java compiler builds a default constructor for that class.",
            "An Object is first declared, then instantiated and then it is initialized.",
            "Default value of byte datatype is 0.",
            "Default value of float and double datatype in different as compared to C/C++. For float its 0.0f and for double it’s 0.0d",
            "This data type is used to save space in large arrays, mainly in place of integers, since a byte is four times smaller than an int.",
            "Class variables also known as static variables are declared with the static keyword in a class, but outside a method, constructor or a block.",
            "Java provides access modifiers to set access levels for classes, variables, methods and constructors. A member has package or default accessibility when no accessibility modifier is specified.",
            "Variables, methods and constructors which are declared protected in a superclass can be accessed only by the subclasses in other package or any class within the package of the protected members' class.",
            "Java provides these modifiers for providing functionalities other than Access Modifiers, synchronized used to indicate that a method can be accessed by only one thread at a time.",
            "Variables used in a switch statement can be used with which datatypes?",
            "Postfix operators i.e () [] . is at the highest precedence.",
            "Variables used in a switch statement can only be a string, enum, byte, short, int, or char.",
            "This method is used to get the primitive data type of a certain String.",
            "The String class is immutable, so that once it is created a String object cannot be changed. Since String is immutable it can safely be shared between many threads ,which is considered very important for multithreaded programming.",
            "The String class is considered as immutable, so that once it is created a String object cannot be changed. If there is a necessity to make alot of modifications to Strings of characters then StringBuffer should be used.",
            "Use StringBuilder whenever possible because it is faster than StringBuffer. But, if thread safety is necessary then use StringBuffer objects.",
    };



    public static final String[] C_INERVIEW_QUESTIONS = new String[]{
            "What is a pointer on pointer?",
            "What is NULL pointer?",
            "What is dandling pointer?",
            "What is a token?",
            "What are bit fields?",
            "Is FILE a built-in data type?",
            "What is a static function?",
    };

    public static final String[] C_INERVIEW_QUESTIONS_A = new String[]{
            "It’s a pointer variable which can hold the address of another pointer variable. It de-refers twice to point to the data held by the designated pointer variable.",
            "A pointer pointing to nothing is called so. Eg: char *p=NULL;",
            "A pointer initially holding valid address, but later the held address is released or freed. Then such a pointer is called as dangling pointer.",
            "A C program consists of various tokens and a token is either a keyword, an identifier, a constant, a string literal, or a symbol.",
            "We can create integer structure members of differing size apart from non-standard size using bit fields. Such structure size is automatically adjusted with the multiple of integer size of the machine.",
            "No, it is a structure defined in stdio.h.",
            "A function’s definition prefixed with static keyword is called as a static function. You would make a function static if it should be called only within the same source code.",
    };

    public static final String[] OS_INERVIEW_QUESTIONS = new String[]{
            "What is the relationship between operating systems and computer hardware?",
            "How Buffering can improve the performance of a Computer system?",
            "What are the primary differences between Network Operating System and Distributed Operating System?",
            "What is the difference between Job and Process?",
            "What are the advantages of multiprogramming?",
            "What are the advantages of Multiprocessing or Parallel System?",
            "What are the differences between Batch processing system and Real Time Processing System?",
            "What are the differences between Real Time System and Timesharing System?",
            "What are the differences between multiprocessing and multiprogramming?",

            "What is a process scheduler? State the characteristics of a good process scheduler?\n" +
                    "OR\n" + "What is scheduling? What criteria affect the scheduler's performance?",

            "Explain time slicing? How its duration affects the overall working of the system?",
            "What is Shortest Remaining Time, SRT scheduling?",
            "What is Highest Response Ratio Next (HRN) Scheduling?",
            "What are the different principles which must be considered while selection of a scheduling algorithm?",
            "Explain pseudo parallelism. Describe the process model that makes parallelism easier to deal with.",
            "What are the differences between paging and segmentation?",
            "When does a page fault occur? Explain various page replacement strategies/algorithms."
    };


    public static final String[] OS_INERVIEW_QUESTIONS_A = new String[]{
            "Operating system helps to make computer hardware available to the application programs. Without Operating System we cannot access computer hardware.",

            "If C.P.U and I/O devices are nearly same at speed, the buffering helps in making the C.P.U and the I/O devices work at full speed in such a way that C.P.U and the I/O devices never sit idle at any moment.\n" +
                    "\n" +
                    "Normally the C.P.U is much faster than an input device. In this case the C.P.U always faces an empty input buffer and sits idle waiting for the input device which is to read a record into the buffer.For output, the C.P.U continues to work at full speed till the output buffer is full and then it starts waiting.\n" +
                    "\n" +
                    "Thus buffering proves useful for those jobs that have a balance between computational work and I/O operations. In other cases, buffering scheme may not work well.",

            "Network and Distributed Operating systems have a common hardware base, but the difference lies in software.",

            "Operating system is a required component of the computer system.\n" +
                    "\n" +
                    "Without an operating system computer hardware is only an inactive electronic machine, which is inconvenient to user for execution of programs.\n" +
                    "\n" +
                    "As the computer hardware or machine understands only the machine language. It is difficult to develop each and every program in machine language in order to execute it.\n" +
                    "\n" +
                    "Thus without operating system execution of user program or to solve user problems is extremely difficult.",

            "A process refers to a program under execution. This program may be an application or system program.\n" +
                    "\n" +
                    "Job means an application program and it is not a system program.",

            "Advantages of multiprogramming are −\n" +
                    "\n" +
                    "    Increased CPU Utilization − Multiprogramming improves CPU utilization as it organizes a number of jobs where CPU always has one to execute.\n" +
                    "\n" +
                    "    Increased Throughput − Throughput means total number of programs executed over a fixed period of time. In multiprogramming, CPU does not wait for I/O for the program it is executing, thus resulting in an increased throughput.\n" +
                    "\n" +
                    "    Shorter Turn around Time − Turnaround time for short jobs is improved greatly in multiprogramming.\n" +
                    "\n" +
                    "    Improved Memory Utilization − In multiprogramming, more than one program resides in main memory. Thus memory is optimally utilized.\n" +
                    "\n" +
                    "    Increased Resources Utilization − In multiprogramming, multiple programs are actively competing for resources resulting in higher degree of resource utilization.\n" +
                    "\n" +
                    "    Multiple Users − Multiprogramming supports multiple users.\n",

            "Multiprocessing operating system or the parallel system support the use of more than one processor in close communication.\n" +
                    "\n" +
                    "The advantages of the multiprocessing system are:\n" +
                    "\n" +
                    "    Increased Throughput − By increasing the number of processors, more work can be completed in a unit time.\n" +
                    "\n" +
                    "    Cost Saving − Parallel system shares the memory, buses, peripherals etc. Multiprocessor system thus saves money as compared to multiple single systems. Also, if a number of programs are to operate on the same data, it is cheaper to store that data on one single disk and shared by all processors instead of using many copies of the same data.\n" +
                    "\n" +
                    "    Increased Reliability − In this system, as the workload is distributed among several processors which results in increased reliability. If one processor fails then its failure may slightly slow down the speed of the system but system will work smoothly.\n",

            "Following are the differences between Batch processing system and Real Time Processing System.\n" +
                    "\tBatch Processing System \tRealtime Processing System\n" +
                    "\tJobs with similar requirements are batched together and run through the computer as a group. | \tIn this system, events mostly external to computer system are accepted and processed within certain deadlines.\n" +
                    "\tThis system is particularly suited for applications such as Payroll, Forecasting, Statistical analysis etc. | \tThis processing system is particularly suited for applications such as scientific experiments, Flight control, few military applications, Industrial control etc.\n" +
                    "\tIt provides most economical and simplest processing method for business applications. | \tComplex and costly processing requires unique hardware and software to handle complex operating system programs.\n" +
                    "\tIn this system data is collected for defined period of time and is processed in batches. | \tSupports random data input at random time.\n" +
                    "\tIn this system sorting is performed before processing. | \tNo sorting is required.\n" +
                    "\tIt is measurement oriented. \tIt is action or event oriented.\n" +
                    "\tTransactions are batch processed and periodically. | \tTransactions are processed as and when they occur.\n" +
                    "\tIn this processing there is no time limit. | \tIt has to handle a process within the specified time limit otherwise the system fails.",

            "Following are the differences between Real Time system and Timesharing System.\n" +
                    "\tReal Time System \tTimesharing System\n" +
                    "\tIn this system, events mostly external to computer system are accepted and processed within certain deadlines. | \tIn this system, many users are allowed to simultaneously share the computer resources.\n" +
                    "\tReal time processing is mainly devoted to one application. | \tTime sharing processing deals with many different applications.\n" +
                    "\tUser can make inquiry only and cannot write or modify programs. | \tUsers can write and modify programs.\n" +
                    "\tUser must get a response within the specified time limit; otherwise it may result in a disaster. | \tUser should get a response within fractions of seconds but if not, the results are not disastrous.\n" +
                    "\tNo context switching takes place in this system. | \tThe CPU switches from one process to another as a time slice expires or a process terminates.",

            "Following are the differences between multiprocessing and multiprogramming.\n" +
                    "\tMultiprocessing | \tMultiprogramming\n" +
                    "\tMultiprocessing refers to processing of multiple processes at same time by multiple CPUs. | \tMultiprogramming keeps several programs in main memory at the same time and execute them concurrently utilizing single CPU.\n" +
                    "\tIt utilizes multiple CPUs. | \tIt utilizes single CPU.\n" +
                    "\tIt permits parallel processing. | \tContext switching takes place.\n" +
                    "\tLess time taken to process the jobs. | \tMore Time taken to process the jobs.\n" +
                    "\tIt facilitates much efficient utilization of devices of the computer system. | \tLess efficient than multiprocessing.\n" +
                    "\tUsually more expensive. | \tSuch systems are less expensive.",

            "Scheduling can be defined as a set of policies and mechanisms which controls the order in which the work to be done is completed. The scheduling program which is a system software concerned with scheduling is called the scheduler and the algorithm it uses is called the scheduling algorithm.\n" +
                    "\n" +
                    "Various criteria or characteristics that help in designing a good scheduling algorithm are:\n" +
                    "\n" +
                    "    CPU Utilization − A scheduling algorithm should be designed so that CPU remains busy as possible. It should make efficient use of CPU.\n" +
                    "\n" +
                    "    Throughput − Throughput is the amount of work completed in a unit of time. In other words throughput is the processes executed to number of jobs completed in a unit of time. The scheduling algorithm must look to maximize the number of jobs processed per time unit.\n" +
                    "\n" +
                    "    Response time − Response time is the time taken to start responding to the request. A scheduler must aim to minimize response time for interactive users.\n" +
                    "\n" +
                    "    Turnaround time − Turnaround time refers to the time between the moment of submission of a job/ process and the time of its completion. Thus how long it takes to execute a process is also an important factor.\n" +
                    "\n" +
                    "    Waiting time − It is the time a job waits for resource allocation when several jobs are competing in multiprogramming system. The aim is to minimize the waiting time.\n" +
                    "\n" +
                    "    Fairness − A good scheduler should make sure that each process gets its fair share of the CPU.\n" +
                    "\n",

            "Time slicing is a scheduling mechanism/way used in time sharing systems. It is also termed as Round Robin scheduling. The aim of Round Robin scheduling or time slicing scheduling is to give all processes an equal opportunity to use CPU. In this type of scheduling, CPU time is divided into slices that are to be allocated to ready processes. Short processes may be executed within a single time quantum. Long processes may require several quanta.",

            "Shortest Remaining Time, SRT is a preemptive scheduling. In SRT, the process with smallest runtime to complete (i.e remaining time) is scheduled to run next, including new arrivals. In SRT, a running process may be preempted by new process with shorter estimated run time. It keeps track of the elapsed service time of the running process and handles occasional preemption. ",
            "\n" +
                    "\n" +
                    "    HRN is non-preemptive scheduling algorithm.\n" +
                    "\n" +
                    "    In Shortest Job First scheduling, priority is given to shortest job, which may sometimes indefinite blocking of longer job.\n" +
                    "\n" +
                    "    HRN Scheduling is used to correct this disadvantage of SJF.\n" +
                    "\n" +
                    "    For determining priority, not only the job's service time but the waiting time is also considered.\n" +
                    "\n" +
                    "    In this algorithm, dynamic priorities are used instead of fixed priorities.\n" +
                    "\n" +
                    "    Dynamic priorities in HRN are calculated as\n" +
                    "\n" +
                    "    Priority = (waiting time + service time) / service time.\n" +
                    "\n" +
                    "    So shorter jobs get preference over longer processes because service time appears in the denominator.\n" +
                    "\n" +
                    "    Longer jobs that have been waiting for long period are also give favorable treatment because waiting time is considered in numerator.\n",

            "The objective/principle which should be kept in view while selecting a scheduling policy are the following −\n" +
                    "\n" +
                    "    Fairness − All processes should be treated the same. No process should suffer indefinite postponement.\n" +
                    "\n" +
                    "    Maximize throughput − Attain maximum throughput. The largest possible number of processes per unit time should be serviced.\n" +
                    "\n" +
                    "    Predictability − A given job should run in about the same predictable amount of time and at about the same cost irrespective of the load on the system.\n" +
                    "\n" +
                    "    Maximum resource usage − The system resources should be kept busy. Indefinite postponement should be avoided by enforcing priorities.\n" +
                    "\n" +
                    "    Controlled Time − There should be control over the different times −\n" +
                    "\n" +
                    "        Response time\n" +
                    "\n" +
                    "        Turnaround time\n" +
                    "\n" +
                    "        Waiting time\n" +
                    "\n" +
                    "        The objective should be to minimize above mentioned times.\n",

            "All modern computers can do many things at the same time. For Example computer can be reading from a disk and printing on a printer while running a user program. In a multiprogramming system, the CPU switches from program to program, running each program for a fraction of second.\n" +
                    "\n" +
                    "Although the CPU is running only one program at any instant of time. As CPU speed is very high so it can work on several programs in a second. It gives user an illusion of parallelism i.e. several processes are being processed at the same time. This rapid switching back and forth of the CPU between programs gives the illusion of parallelism and is termed as pseudo parallelism. As it is extremely difficult to keep track of multiple, parallel activities, to make parallelism easier to deal with, the operating system designers have evolved a process model.",

            "Following are the differences between paging and segmentation.\n" +
                    "Sr. No.\tPaging\tSegmentation\n" +
                    "1\tA page is a physical unit of information.\tA segment is a logical unit of information.\n" +
                    "2\tA page is invisible to the user's program.\tA segment is visible to the user's program.\n" +
                    "3\tA page is of fixed size e.g. 4Kbytes.\tA segment is of varying size.\n" +
                    "4\tThe page size is determined by the machine architecture.\tA segment size is determined by the user.\n" +
                    "5\tFragmentation may occur.\tSegmentation eliminates fragmentation.\n" +
                    "6\tPage frames on main memory are required.\tNo frames are required.",

            "In demand paging memory management technique, if a page demanded for execution is not present in main memory, then a page fault occurs. To load the page in demand into main memory, a free page frame is searched in main memory and allocated. If no page frame is free, memory manager has to free a frame by swapping its contents to secondary storage and thus make room for the required page. To swap pages, many schemes or strategies are used."
    };


    public static final String[] DSA_INERVIEW_QUESTIONS = new String[]{
            "What is data-structure?",
            "What are various data-structures available?",
            "What is algorithm?",
            "Why we need to do algorithm analysis?",
            "What are the criteria of algorithm analysis?",
            "What is asymptotic analysis of an algorithm?",
            "What are asymptotic notations?",
            "What is linear data structure?",
            "What are common operations that can be performed on a data-structure?",
            "Briefly explain the approaches to develop algorithms.",
            "Give some examples greedy algorithms.",
            "What are some examples of divide and conquer algorithms?",
            "What are some examples of dynamic programming algorithms?",
            "What is a linked-list?",
            "What is stack?",
            "Why do we use stacks?",
            "What operations can be performed on stacks?",
            "What is a queue in data-structure?",
            "Why do we use queues?",
            "What operations can be performed on Queues?",
            "What is linear searching?",
            "What is binary search?",
            "What is bubble sort and how bubble sort works?",
            "Tell me something about 'insertion sort'?",
            "What is selection sort?",
            "How insertion sort and selection sorts are different?",
            "What is merge sort and how it works?"
    };

    public static final String[] DSA_INERVIEW_QUESTIONS_A = new String[]{
            "Data structure is a way of defining, storing & retriving of data in a structural & systemetic way. A data structure may contain different type of data items.",
            "Data structure availability may vary by programming languages. Commonly available data structures are list, arrays, stack, queues, graph, tree etc.",
            "Algorithm is a step by step procedure, which defines a set of instructions to be executed in certain order to get the desired output.",
            "A problem can be solved in more than one ways. So, many solution algorithms can be derived for a given problem. We analyze available algorithms to find and implement the best suitable algorithm.",
            "An algorithm are generally analyzed on two factors − time and space. That is, how much execution time and how much extra space required by the algorithm.",
            "Asymptotic analysis of an algorithm, refers to defining the mathematical boundation/framing of its run-time performance. Using asymptotic analysis, we can very well conclude the best case, average case and worst case scenario of an algorithm.",
            "\n" +
                    "\n" +
                    "Asymptotic analysis can provide three levels of mathematical binding of execution time of an algorithm −\n" +
                    "\n" +
                    "    Best case is represented by Ω(n) notation.\n" +
                    "    Worst case is represented by Ο(n) notation.\n" +
                    "    Average case is represented by Θ(n) notation.\n" +
                    "\n",
            "A linear data-structure has sequentially arranged data items. The next time can be located in the next memory address. It is stored and accessed in a sequential manner. Array and list are example of linear data structure.",
            "\n" +
                    "\n" +
                    "The following operations are commonly performed on any data-structure −\n" +
                    "\n" +
                    "    Insertion − adding a data item\n" +
                    "\n" +
                    "    Deletion − removing a data item\n" +
                    "\n" +
                    "    Traversal − accessing and/or printing all data items\n" +
                    "\n" +
                    "    Searching − finding a particular data item\n" +
                    "\n" +
                    "    Sorting − arranging data items in a pre-defined sequence\n" +
                    "\n",
            "\n" +
                    "\n" +
                    "There are three commonly used approaches to develop algorithms −\n" +
                    "\n" +
                    "    Greedy Approach − finding solution by choosing next best option\n" +
                    "\n" +
                    "    Divide and Conquer − diving the problem to a minimum possible sub-problem and solving them independently\n" +
                    "\n" +
                    "    Dynamic Programming − diving the problem to a minimum possible sub-problem and solving them combinedly\n" +
                    "\n",
            "\n" +
                    "\n" +
                    "The below given problems find their solution using greedy algorithm approach −\n" +
                    "\n" +
                    "    Travelling Salesman Problem\n" +
                    "    Prim's Minimal Spanning Tree Algorithm\n" +
                    "    Kruskal's Minimal Spanning Tree Algorithm\n" +
                    "    Dijkstra's Minimal Spanning Tree Algorithm\n" +
                    "    Graph - Map Coloring\n" +
                    "    Graph - Vertex Cover\n" +
                    "    Knapsack Problem\n" +
                    "    Job Scheduling Problem\n" +
                    "\n",
            "\n" +
                    "\n" +
                    "The below given problems find their solution using divide and conquer algorithm approach −\n" +
                    "\n" +
                    "    Merge Sort\n" +
                    "    Quick Sort\n" +
                    "    Binary Search\n" +
                    "    Strassen's Matrix Multiplication\n" +
                    "    Closest pair (points)\n" +
                    "\n",
            "\n" +
                    "\n" +
                    "The below given problems find their solution using divide and conquer algorithm approach −\n" +
                    "\n" +
                    "    Fibonacci number series\n" +
                    "    Knapsack problem\n" +
                    "    Tower of Hanoi\n" +
                    "    All pair shortest path by Floyd-Warshall\n" +
                    "    Shortest path by Dijkstra\n" +
                    "    Project scheduling\n" +
                    "\n",
            "A linked-list is a list of data-items connected with links i.e. pointers or references. Most modern high-level programming language does not provide the feature of directly accessing memory location, therefore, linked-list are not supported in them or available in form of inbuilt functions.",
            "In data-structure, stack is an Abstract Data Type (ADT) used to store and retrieve values in Last In First Out method.",
            "Stacks follows LIFO method and addition and retrieval of a data item takes only Ο(n) time. Stacks are used where we need to access data in the reverse order or their arrival. Stacks are used commonly in recursive function calls, expression parsing, depth first traversal of graphs etc.",
            "\n" +
                    "\n" +
                    "The below operations can be performed on a stack −\n" +
                    "\n" +
                    "    push() − adds an item to stack\n" +
                    "\n" +
                    "    pop() − removes the top stack item\n" +
                    "\n" +
                    "    peek() − gives value of top item without removing it\n" +
                    "\n" +
                    "    isempty() − checks if stack is empty\n" +
                    "\n" +
                    "    isfull() − checks if stack is full\n" +
                    "\n",
            "Queue is an abstract data structure, somewhat similar to stack. In contrast to stack, queue is opened at both end. One end is always used to insert data (enqueue) and the other is used to remove data (dequeue). Queue follows First-In-First-Out methodology, i.e., the data item stored first will be accessed first.",
            "As queues follows FIFO method, they are used when we need to work on data-items in exact sequence of their arrival. Every operating system maintains queues of various processes. Priority queues and breadth first traversal of graphs are some examples of queues.",
            "\n" +
                    "\n" +
                    "The below operations can be performed on a stack −\n" +
                    "\n" +
                    "    enqueue() − adds an item to rear of the queue\n" +
                    "\n" +
                    "    dequeue() − removes the item from front of the queue\n" +
                    "\n" +
                    "    peek() − gives value of front item without removing it\n" +
                    "\n" +
                    "    isempty() − checks if stack is empty\n" +
                    "\n" +
                    "    isfull() − checks if stack is full\n" +
                    "\n",
            "Linear search tries to find an item in a sequentially arranged data type. These sequentially arranged data items known as array or list, are accessible in incrementing memory location. Linear search compares expected data item with each of data items in list or array. The average case time complexity of linear search is Ο(n) and worst case complexity is Ο(n2). Data in target arrays/lists need not to be sorted.",
            "\n" +
                    "\n" +
                    "A binary search works only on sorted lists or arrays. This search selects the middle which splits the entire list into two parts. First the middle is compared.\n" +
                    "\n" +
                    "This search first compares the target value to the mid of the list. If it is not found, then it takes decision on whether.\n",
            "Bubble sort is comparison based algorithm in which each pair of adjacent elements is compared and elements are swapped if they are not in order. Because the time complexity is Ο(n2), it is not suitable for large set of data.",
            "Insertion sort divides the list into two sub-list, sorted and unsorted. It takes one element at time and finds it appropriate location in sorted sub-list and insert there. The output after insertion is a sorted sub-list. It iteratively works on all the elements of unsorted sub-list and inserts them to sorted sub-list in order.",
            "Selection sort is in-place sorting technique. It divides the data set into two sub-lists: sorted and unsorted. Then it selects the minimum element from unsorted sub-list and places it into the sorted list. This iterates unless all the elements from unsorted sub-list are consumed into sorted sub-list.",
            "Both sorting techniques maintains two sub-lists, sorted and unsorted and both take one element at a time and places it into sorted sub-list. Insertion sort works on the current element in hand and places it in the sorted array at appropriate location maintaining the properties of insertion sort. Whereas, selection sort searches the minimum from the unsorted sub-list and replaces it with the current element in hand.",
            "Merge sort is sorting algorithm based on divide and conquer programming approach. It keeps on dividing the list into smaller sub-list until all sub-list has only 1 element. And then it merges them in a sorted way until all sub-lists are consumed. It has run-time complexity of Ο(n log n) and it needs Ο(n) auxiliary space."
    };
}
