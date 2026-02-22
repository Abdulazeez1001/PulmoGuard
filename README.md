# 🫁 PulmoGuard — Predictive COPD Exacerbation Monitoring App

An Android mHealth application for early detection of COPD exacerbations, built with **Jetpack Compose** and a personalized **Machine Learning pipeline**.

> Detects exacerbation risk **3–7 days in advance** and routes alerts to a care team dashboard to trigger evidence-based interventions.

---

## ✨ Features

### Core Functionality
- **Custom FEV₁ Gauge** — Circular arc drawn from scratch using Jetpack Compose `Canvas`, no third-party library
- **ML Risk Clustering** — K-Means model classifies daily spirometry into 4 risk levels: Normal, Mild, Moderate, Severe
- **Trend Charts** — Fully custom line + bar chart built with Canvas, animated tab switching (Today / Weekly / Monthly)
- **Care Chat** — Structured async messaging between patient and care provider
- **Health Report Generator** — Auto-summarizes lung health, vitals, and doctor notes into a shareable report
- **Authentication Flow** — Sign In and Create Account screens with form validation

### User Experience
- **Warm Design Language** — Custom beige-brown palette (sand / almond / cocoa) across all screens
- **Thumb-Zone Optimized** — All interactive elements within 48dp tap targets, one-hand usable
- **Minimal Cognitive Load** — Each screen has one focused task: monitor, reflect, communicate, or manage
- **Empathetic Micro-copy** — Reassuring language ("Breathing looks stable today") to reduce patient anxiety

---

## 📱 Screens

| Screen | Description |
|--------|-------------|
| **Vitals** | FEV₁ gauge + Heart Rate, O₂ Level, Steps |
| **Insights** | Trend charts with Today / Weekly / Monthly tabs |
| **Care Chat** | AI-assisted doctor messaging |
| **Health Report** | Auto-generated lung health summary |
| **Profile** | Patient info, clinician details, inhaler toggle |

---

## 🛠 Tech Stack

- **Language:** Kotlin 100%
- **UI Framework:** Jetpack Compose
- **Architecture:** Screen-based navigation with NavController
- **ML:** K-Means clustering (trained offline in Python, cluster centers encoded on-device)
- **Build System:** Gradle with Kotlin DSL

---

## 🧠 ML Pipeline

Daily spirometry inputs (FEV₁, FVC, FEV₁/FVC ratio, peak flow) are normalized and mapped to one of 4 risk clusters:

- `Cluster 0` — **Normal:** Values near baseline, no concerning trend
- `Cluster 1` — **Mild Risk:** Small but consistent FEV₁ decline
- `Cluster 2` — **Moderate Risk:** Multi-day decline + activity reduction
- `Cluster 3` — **Severe Risk:** Large decline, triggers care team alert

---

## 📋 Clinical Context

COPD hospitalizations cost **$10,000–15,000 per event**. PulmoGuard targets the 3–7 day detection window before symptoms worsen, enabling pulmonary rehabilitation with an evidence-based **NNT of 4–6** to prevent rehospitalization.

---

## 🏗 Project Structure

```
PulmoGuardUI/
└── app/src/main/java/
    ├── com/example/pulmoguardui/
    │   ├── MainActivity.kt
    │   ├── SignInActivity.kt
    │   ├── CreateAccountActivity.kt
    │   └── HomeActivity.kt
    └── ui/
        ├── screens/
        │   ├── VitalScreen.kt
        │   ├── InsightScreen.kt
        │   ├── CareChatScreen.kt
        │   ├── HealthReport.kt
        │   └── ProfileScreen.kt
        ├── navigation/
        ├── home/
        ├── components/
        └── theme/
```

---

**Abdul Azeez**  
Health Informatics — DePaul University  
[LinkedIn](https://www.linkedin.com/in/abdulazeez3/)
