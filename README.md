<div align="center">

# ⚙️ CPU Scheduling Simulator

**A desktop application that simulates and compares Priority Preemptive and SRTF scheduling algorithms — with Gantt charts, statistics, and side-by-side analysis.**

[![Java](https://img.shields.io/badge/Java-8%2B-ED8B00?style=flat-square&logo=openjdk&logoColor=white)](https://www.java.com)
[![UI](https://img.shields.io/badge/UI-Java%20Swing-5C5CFF?style=flat-square)](/)
[![OS](https://img.shields.io/badge/Topic-Operating%20Systems-gray?style=flat-square)](/)
[![License](https://img.shields.io/badge/License-MIT-blue?style=flat-square)](LICENSE)

</div>

---

## 📋 Table of Contents

- [About](#-about)
- [Algorithms](#-algorithms)
- [Features](#-features)
- [Project Structure](#-project-structure)
- [Getting Started](#-getting-started)
- [How to Use](#-how-to-use)
- [Metrics Explained](#-metrics-explained)
- [License](#-license)

---

## 🧾 About

CPU Scheduling Simulator is a Java Swing desktop application built as an Operating Systems course project. It lets you define a set of processes and instantly compare how **Priority Preemptive** and **SRTF (Shortest Remaining Time First)** scheduling algorithms handle them — visually through Gantt charts and numerically through performance metrics.

---

## 🧠 Algorithms

### Priority Preemptive
- At every time unit, the ready process with the **lowest priority number** (highest priority) runs.
- Ties broken by: arrival time → remaining burst time.
- A higher-priority process **preempts** the currently running one immediately upon arrival.

### SRTF — Shortest Remaining Time First
- At every time unit, the ready process with the **shortest remaining burst time** runs.
- Ties broken by: arrival time → priority number.
- Preemptive version of SJF — a new process can preempt the current one if it has a shorter remaining time.

---

## ✨ Features

| Feature | Description |
|---|---|
| ➕ Process Input | Add processes manually with PID, Arrival Time, Burst Time, and Priority |
| 🎬 Quick Scenarios | 4 pre-loaded scenarios (A, B, C, D) for instant testing |
| 📊 Gantt Charts | Color-coded visual timeline for both algorithms side by side |
| 📋 Results Table | Per-process breakdown: Finish Time, Waiting Time, Turnaround Time, Response Time |
| 📈 Averages | Avg WT, Avg TAT, Avg RT for each algorithm |
| 🔍 Comparison | Side-by-side analysis tab explaining which algorithm wins and why |
| 🌙 Dark UI | Custom dark theme with colored accents |

---

## 📁 Project Structure

```
scheduler_project/
│
├── src/
│   ├── Main.java                # Entry point — launches MainFrame
│   ├── MainFrame.java           # Main window with 4 tabs (Input, Gantt, Results, Analysis)
│   ├── Process.java             # Process model (PID, arrival, burst, priority + computed metrics)
│   ├── SchedulerResult.java     # Result container (Gantt list + process list + averages)
│   ├── PriorityScheduler.java   # Priority Preemptive algorithm implementation
│   ├── SRTFScheduler.java       # SRTF algorithm implementation
│   ├── GanttPanel.java          # Custom Swing panel for drawing Gantt charts
│   └── ResultsTablePanel.java   # Custom Swing panel for the results table
│
├── out/                         # Compiled .class files (auto-generated)
├── run.sh                       # One-click compile & run (Linux / macOS)
├── run.bat                      # One-click compile & run (Windows)
└── README.md
```

---

## 🚀 Getting Started

### Prerequisites

- Java JDK **8 or higher**

### Windows

Double-click `run.bat` or run in terminal:

```bat
run.bat
```

### Linux / macOS

```bash
chmod +x run.sh
./run.sh
```

### Manual (any OS)

```bash
mkdir -p out
javac -d out src/*.java
java -cp out Main
```

---

## 🖥️ How to Use

The app has **4 tabs**:

**① Input**
- Enter PID, Arrival Time, Burst Time, and Priority for each process
- Click **Add** to add it to the list
- Or click one of the **Scenario A/B/C/D** buttons to load a pre-built test case
- Click **Run Schedulers** to simulate both algorithms

**② Gantt Charts**
- Color-coded timeline showing execution order for both algorithms
- Each block represents one time unit of CPU execution

**③ Results**
- Per-process table showing:
  - Finish Time, Waiting Time, Turnaround Time, Response Time
- Average WT / TAT / RT for each algorithm

**④ Analysis**
- Auto-generated comparison explaining which algorithm performed better and why

---

## 📐 Metrics Explained

| Metric | Formula | Meaning |
|---|---|---|
| **Turnaround Time (TAT)** | Finish Time − Arrival Time | Total time from arrival to completion |
| **Waiting Time (WT)** | TAT − Burst Time | Time spent waiting in the ready queue |
| **Response Time (RT)** | First CPU time − Arrival Time | Time until process first gets the CPU |

> Priority notation: **1 = highest priority**, higher numbers = lower priority.

---

## 📄 License

This project is open source and available under the [MIT License](LICENSE).

---

<div align="center">
  Built with Java ☕ &nbsp;·&nbsp; Operating Systems Course Project
</div>
