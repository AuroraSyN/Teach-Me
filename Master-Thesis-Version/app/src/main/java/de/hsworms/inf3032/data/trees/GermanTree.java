package de.hsworms.inf3032.data.trees;

import java.util.Arrays;
import java.util.List;

public class GermanTree {

    public static final List<String> GERMAN_TREE = Arrays.asList(
            "C ++ Grundlagen",
            "C ++ Objektorientiert",
            "Betriebssystem",
            "Java 9 ",
            "Java-Grundlagen",
            "Java Advanced ",
            "DSA-Grundlagen",
            "DSA Advanced "
    );

    public static final List<String> CS_GERMAN_INTERVIEW_TREE = Arrays.asList(
            "Java Interviewfragen",
            "C++ Interviewfragen",
            "Operating System Interviewfragen",
            "DSA Interviewfragen"
    );

    public static final String[] JAVA_INERVIEW_QUESTIONS = new String[]{
            "Was weißt du über Java?",
            "Was sind die unterstützten Plattformen von Java Programmiersprache?",
            "Liste alle fünf Funktionen von Java auf?",
            "Warum ist die Java-Architektur Neutral?",
            "Wie Java aktiviert Hohe Leistung?",
            "Warum wird Java als dynamisch betrachtet?",
            "Liste zwei Java IDS auf?",
            "Einige Java-keywords auflisten (im Gegensatz zu C, C++ - keywords)?",
            "Was meinst du mit Objekt?",
            "Klasse definieren?",
            "Aus welchen Variablen kann eine Klasse bestehen?",
            "Was ist eine Lokale Variable?",
            "Was ist eine Instanzvariable?",
            "Was ist eine Klassenvariable?",
            "Was ist Singleton-Klasse?",
            "Was meinen Sie mit Konstruktor?",
            "Liste die drei Schritte zum erstellen eines Objekts für eine Klasse auf?",
            "Was ist der Standardwert von byte-Datentyp in Java?",
            "Was ist der Standardwert von float und double datatype in Java?",
            "Wenn ein byte-Datentyp verwendet wird?",
            "Was ist eine statische variable?",
            "Was meinen Sie mit Access Modifier?",
            "Was ist protected access modifier?",
            "Was meinen Sie mit synchronized Non Access Modifier?",
            "Nach Java Operator precedence, welcher operator gilt als mit höchster Priorität sein?",
            "Variablen, die in einer switch-Anweisung kann verwendet werden, mit dem Datentypen?",
            "Wenn parseInt () - Methode verwendet werden kann?",
            "Warum wird String-Klasse als unveränderlich angesehen?",
            "Warum heißt StringBuffer mutable?",
            "Was ist der Unterschied zwischen StringBuffer und StringBuilder-Klasse?"
    };

    public static final String[] JAVA_INERVIEW_QUESTIONS_A = new String[]{
            "Java ist eine hochgradige Programmiersprache, die ursprünglich von Sun Microsystems entwickelt und 1995 veröffentlicht wurde. Java läuft auf einer Vielzahl von Plattformen, wie Windows, Mac OS, und die verschiedenen Versionen von UNIX.",
            "Java läuft auf einer Vielzahl von Plattformen, wie Windows, Mac OS und die verschiedenen Versionen des UNIX/Linux HP-Unix, Sun Solaris, Redhat Linux, Ubuntu, CentOS, etc.",
            "Liste alle fünf Funktionen von Java auf?",
            "Es ist compiler erzeugt ein architekturneutrales objektdateiformat, das den kompilierten code auf vielen Prozessoren ausführbar macht, mit dem Vorhandensein von Java runtime system.",
            "Java verwendet Just-In-Time-compiler, um hohe Leistung zu ermöglichen. Just-In-Time compiler ist ein Programm, das Java-bytecode dreht, ein Programm, das Anweisungen enthält, die in Anweisungen interpretiert werden müssen, die direkt an den Prozessor gesendet werden können.",
            "Wenn Java kompiliert wird, wird es nicht in plattformspezifische Maschine kompiliert, sondern in plattformunabhängigen byte-code. Dieser byte-code wird über das web verteilt und von virtual Machine (JVM) auf jeder Plattform interpretiert.",
            "Netbeans, Eclipse, etc.",
            "Einige Java-Schlüsselwörter sind import, super, schließlich usw.",
            "Objekt ist ein Laufzeit-Entität und dessen Zustand gespeichert wird, der in Felder und das Verhalten gezeigt wird via Methoden. Methoden arbeiten im internen Zustand eines Objekts und dienen als primärmechanismus für die Objekt-zu-Objekt-Kommunikation.",
            "Eine Klasse ist ein Blaudruck, aus dem einzelne Objekte erstellt werden. Eine Klasse kann Felder und Methoden enthalten, um das Verhalten eines Objekts zu beschreiben.",
            "Eine Klasse besteht aus Lokalen Variablen, Instanzvariablen und Klassenvariablen.",
            "Variablen, die in Methoden, Konstruktoren oder Blöcken definiert sind, werden lokale Variablen genannt. Die variable wird innerhalb der Methode deklariert und initialisiert und nach Abschluss der Methode zerstört.",
            "Instanzvariablen sind Variablen innerhalb einer Klasse, aber außerhalb jeder Methode. Diese Variablen werden instanziiert, wenn die Klasse geladen wird.",
            "Dies sind Variablen, die in einer Klasse außerhalb jeder Methode mit dem statischen Schlüsselwort deklariert werden.",
            "Singleton-Klassen-Objekt-Erstellung, die Beschränkung der Anzahl auf eine, sondern ermöglicht die notwendige Flexibilität für die Erstellung mehrerer Objekte, wenn sich die situation ändert.",
            "Konstruktor wird aufgerufen, wenn ein neues Objekt erstellt wird. Jede Klasse hat einen Konstruktor. Wenn wir nicht explizit einen Konstruktor für eine Klasse schreiben, erstellt der java-compiler einen Standardkonstruktor für diese Klasse.",
            "Ein Objekt wird zuerst deklariert, dann instanziiert und dann initialisiert.",
            "Standardwert des byte-Datentyps ist 0.",
            "Standardwert von float und double-Datentyp in verschiedenen im Vergleich zu C / C++. Für float seine 0.0 f und für double ist es 0.0 d",
            "Dieser Datentyp wird verwendet, um Platz in großen arrays zu sparen, hauptsächlich anstelle von Ganzzahlen, da ein byte viermal kleiner als ein int ist.",
            "Klassenvariablen, die auch als statische Variablen bekannt sind, werden mit dem statischen Schlüsselwort in einer Klasse deklariert, jedoch außerhalb einer Methode, eines Konstruktors oder eines Blocks.",
            "Java bietet zugriffsmodifikatoren zum festlegen von Zugriffsebenen für Klassen, Variablen, Methoden und Konstruktoren. Ein Mitglied hat Paket-oder Standardzugriff, wenn kein accessibility modifier angegeben ist.",
            "Variablen, Methoden und Konstruktoren, die in einer Superklasse als geschützt deklariert sind, können nur von den Unterklassen in einem anderen Paket oder einer Klasse innerhalb des Pakets der protected members Klasse aufgerufen werden.",
            "Java stellt diese Modifikatoren zur Verfügung, um andere Funktionalitäten als Access Modifiers zur Verfügung zu stellen, synchronisiert, um anzuzeigen, dass auf eine Methode jeweils nur ein thread zugreifen kann.",
            "Variablen, die in einer switch-Anweisung kann verwendet werden, mit dem Datentypen?",
            "Postfix-Operatoren, d.h. () [] . ist an der höchsten Priorität.",
            "Variablen, die in einer switch-Anweisung verwendet werden, können nur string, enum, byte, short, int oder char sein.",
            "Diese Methode wird verwendet, um den primitiven Datentyp einer bestimmten Zeichenfolge zu erhalten.",
            "Die String-Klasse ist unveränderlich, so dass nach der Erstellung ein String-Objekt nicht geändert werden kann. Da String unveränderlich ist, kann Es sicher zwischen vielen threads geteilt werden, was für die Multithread-Programmierung sehr wichtig ist.",
            "Die String-Klasse wird als unveränderlich betrachtet, so dass nach der Erstellung ein String-Objekt nicht geändert werden kann. Wenn es eine Notwendigkeit, um eine Menge von änderungen an Zeichenfolgen, Zeichen dann StringBuffer sollten verwendet werden.",
            "Verwenden Sie StringBuilder, wenn möglich, weil es schneller als StringBuffer ist. Aber wenn thread-Sicherheit notwendig ist, dann verwenden Sie StringBuffer-Objekte.",
    };



    public static final String[] C_INERVIEW_QUESTIONS = new String[]{
            "Was ist ein Zeiger auf Zeiger?",
            "Was ist NULL-Zeiger?",
            "Was ist dandling pointer?",
            "Was ist ein token?",
            "Was sind Bitfelder?",
            "Ist DATEI ein eingebauter Datentyp?",
            "Was ist eine statische Funktion?",
    };

    public static final String[] C_INERVIEW_QUESTIONS_A = new String[]{
            "Es ist eine Zeigervariable, die die Adresse einer anderen Zeigervariable enthalten kann. Es de-bezieht sich zweimal auf die Daten der angegebenen Zeigervariable.",
            "Ein Zeiger, der auf nichts zeigt, wird so genannt. ZB: char *p=NULL;",
            "Ein Zeiger hält zunächst gültige Adresse, aber später wird die gehaltene Adresse freigegeben oder freigegeben. Dann wird ein solcher Zeiger als dangling pointer aufgerufen.",
            "Ein C-Programm besteht aus verschiedenen Token und ein token ist entweder ein Schlüsselwort, Bezeichner, einer Konstanten, die eine Zeichenfolge literal oder ein symbol.",
            "Wir können ganzzahlige Strukturelemente unterschiedlicher Größe außer nicht-Standardgröße mit bitfeldern erstellen. Eine solche Strukturgröße wird automatisch mit dem vielfachen der ganzzahligen Größe der Maschine angepasst.",
            "Nein, es ist eine in stdio definierte Struktur.H.",
            "Die definition einer Funktion mit dem Präfix static keyword wird als statische Funktion aufgerufen. Sie würden eine Funktion statisch machen, wenn Sie nur innerhalb desselben Quellcodes aufgerufen werden sollte.",    };

    public static final String[] OS_INERVIEW_QUESTIONS = new String[]{
            "Was ist die Beziehung zwischen Betriebssystemen und Computerhardware?",
            "Wie kann Pufferung die Leistung eines Computersystems verbessern?",
            "Was sind die Hauptunterschiede zwischen Netzbetriebssystem und Verteiltem Betriebssystem?",
            "Was ist der Unterschied zwischen Job und Prozess?",
            "Was sind die Vorteile von multiprogramming?",
            "Was sind die Vorteile von Multiprocessing oder Parallel-System?",
            "Was sind die Unterschiede zwischen Batch-processing-system und Echtzeit-Processing-System?",
            "Was sind die Unterschiede zwischen Echtzeit-System und Timesharing-System?",
            "Was sind die Unterschiede zwischen multiprocessing und multiprogramming?",
            "Was ist ein Prozess-scheduler? Geben Sie die Eigenschaften eines guten prozessplaners an? und+ oder\n" + "Was ist Planung? Welche Kriterien beeinflussen die Leistung des Planers?",
            "Erklären Zeit schneiden? Wie wirkt sich seine Dauer auf die Gesamtarbeit des Systems aus?",
            "Was ist die Kürzeste Verbleibende Zeit, SRT-scheduling?",
            "Was ist Höchste Ansprechrate Next (HRN) Scheduling?",
            "Was sind die verschiedenen Prinzipien, die bei der Auswahl eines planungsalgorithmus berücksichtigt werden müssen?",
            "Erklären pseudo-Parallelität. Beschreiben Sie das Prozessmodell, das Parallelismus einfacher zu handhaben macht.",
            "Was sind die Unterschiede zwischen paging und Segmentierung?",
            "Wann tritt ein page-Fehler auf? Erklären Sie verschiedene seitenersatzstrategien / - algorithmen."
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
            "Was ist eine Datenstruktur?",
            "Welche verschiedenen Datenstrukturen sind verfügbar?",
            "Was ist ein Algorithmus?",
            "Warum müssen wir die Algorithmusanalyse durchführen?",
            "Was sind die Kriterien der Algorithmusanalyse?",
            "Was ist eine asymptotische Analyse eines Algorithmus?",
            "Was sind asymptotische Notationen?",
            "Was ist eine lineare Datenstruktur?",
            "Was sind gängige Operationen, die auf einer Datenstruktur durchgeführt werden können?",
            "Erklären Sie kurz die Ansätze zur Entwicklung von Algorithmen.",
            "Gib ein paar Beispiele für gierige Algorithmen.",
            "Welche Beispiele für Divide and Conquer Algorithmen gibt es?",
            "Welche Beispiele für dynamische Programmieralgorithmen gibt es?",
            "Was ist eine Link-Liste?",
            "Was ist Stapel?",
            "Warum verwenden wir Stapel?",
            "Welche Operationen können auf Stapeln durchgeführt werden?",
            "Was ist eine Warteschlange in der Datenstruktur?",
            "Warum benutzen wir Warteschlangen?",
            "Welche Operationen können an Warteschlangen durchgeführt werden?",
            "Was ist lineare Suche?",
            "Was ist eine binäre Suche?",
            "Was ist Blasensortierung und wie funktioniert Blasensortierung?",
            "Erzähl mir etwas über die Einbausorte?",
            "Was ist eine Auswahlsortierung?",
            "Wie unterscheiden sich Einfügesortierung und Auswahlsortierung?",
            "Was ist Merge-Sortierung und wie funktioniert sie?"
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


    public static final List<String> MC_GERMAN_INTERVIEW_TREE = Arrays.asList(
            "Android ",
            "jQuery "
    );


    public static final String[] JQUERY_QUESTIONS = new String[]{
            "Was ist jQuery?",
            "Was sind die Kernfunktionen von jQuery?",
            "Wie werden Sie sicherstellen, dass DOM mit jQuery bereit ist?",
            "Wie kann man ein Objekt in JavaScript erstellen?",
            "Wie können Sie Eigenschaften eines Objekts in JavaScript Lesen?",
            "Wie können Sie ein Array in JavaScript erstellen?",
            "Wie lese ich Elemente eines Arrays in JavaScript?",
            "Was ist eine benannte Funktion in JavaScript? Wie definiere ich eine benannte Funktion?",
            "Was ist eine benannte Funktion in JavaScript? Wie definiere ich eine benannte Funktion?Wie viele Arten von Funktionen JavaScript unterstützt?",
            "Wie können Sie die Art von Argumenten an eine Funktion übergeben?",
            "Wie können Sie die Gesamtzahl der Argumente an eine Funktion übergeben?",
            "Wie können Sie die Referenz einer anruferfunktion in einer Funktion erhalten?",
            "Was sind die gültigen Bereiche einer Variablen in JavaScript?",
            "Geben Sie ein Beispiel für die Schließung?",
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
            "Was ist Android?",
            "Beschreiben Sie Android-Anwendungsarchitektur?",
            "Was ist Eine Aktivität?",
            "Was ist das APK-format?",
            "Was ist eine Absicht?",
            "Was ist eine explizite Absicht?",
            "Was ist eine implizite Absicht?",
            "Was ist ADB in android?",
            "Definieren Sie die Anwendung Ressource-Datei in android?",
            "Wie starte ich eine Aktivität in android?",
            "Was ist fragment in android?",
            "Welche Ordner sind impotent in android-Projekt?",
            "Was ist drawable Ordner in android?",
    };

    public static final String[] ANDROID_QUESTIONS_A = new String[] {
            "Android ist ein Softwarestapel für mobile Geräte, der ein Betriebssystem, Middleware und einige wichtige Anwendungen umfasst. Die Anwendung wird in einem eigenen Prozess und einer eigenen Instanz von Dalvik Virtual Machine ausgeführt.",
            "Die Android-Anwendungsarchitektur besteht aus folgenden Komponenten:\n" +
                    "\n" +
                    "Dienste - Es werden Hintergrundfunktionen ausgeführt\n" +
                    "\n" +
                    "Absicht - Die Verbindung zwischen Aktivitäten und dem Datenübermittlungsmechanismus wird hergestellt\n" +
                    "\n" +
                    "Ressourcenexternalisierung - Zeichenfolgen und Grafiken\n" +
                    "\n" +
                    "Benachrichtigung - Licht, Ton, Symbol, Benachrichtigung, Dialogfeld und Toast\n" +
                    "\n" +
                    "Inhaltsanbieter - Die Daten werden zwischen Anwendungen geteilt",
            "Aktivität führt Aktionen auf dem Bildschirm aus. Wenn Sie Vorgänge ausführen möchten, können wir diese mit Aktivität ausführen",
            "Der Android-Paketschlüssel wird mit Klassen, Benutzeroberflächen, unterstützenden Elementen und Manifesten komprimiert. Alle Dateien werden zu einer einzigen Datei komprimiert, die als APK bezeichnet wird.",
            "Es ist entweder mit der externen Welt der Anwendung oder der internen Welt der Anwendung verbunden. Das Öffnen eines PDF-Dokuments ist beispielsweise beabsichtigt und stellt eine Verbindung zum Webbrowser her.",
            "Android Explicit Intent gibt die Komponente an, die von der Aktivität aufgerufen werden soll. Mit anderen Worten, wir können eine andere Aktivität in Android durch explizite Absicht aufrufen.",
            "Implicit Intent gibt die Komponente nicht an. In diesem Fall liefert intent Informationen zu verfügbaren Komponenten, die vom aufzurufenden System bereitgestellt werden.\n",
            "Es fungiert als Brücke zwischen Emulator und IDE und führt Remote-Shell-Befehle aus, um Anwendungen auf einem Emulator auszuführen",
            "JSON, XML bitmap.etc sind Anwendungsressourcen. Sie können diese Dateien zum Erstellen einbinden und sie aus dem Code laden.",
            "\n" +
                    "\n" +
                    "Using with intent, we can launch an activity.\n" +
                    "\n" +
                    "Intent intent = new Intent(this, MyTestActivity.class);\n" +
                    "\n" +
                    "        startActivity(intent);\n" +
                    "\n",
            "Fragment ist eine Aktivität. Wenn Sie Ihre Anwendung um 360 Grad drehen möchten, können Sie dies fragmentarisch tun.\n",
            "\n" +
                    "\n" +
                    "AndroidManifest.xml\n" +
                    "\n" +
                    "build.xml\n" +
                    "\n" +
                    "bin/\n" +
                    "\n" +
                    "src/\n" +
                    "\n" +
                    "res/\n" +
                    "\n" +
                    "assets/\n",
            "Eine kompilierte visuelle Ressource, die als Hintergrund, Banner, Symbole, Begrüßungsbildschirm usw. verwendet werden kann.",
    };
}
