PulmoGuard (Predictive COPD Exacerbation Monitoring App)

An Android mHealth application for early detection of COPD exacerbations, built with Jetpack Compose and a personalized Machine Learning pipeline.

Screens
VitalsInsightsCare ChatHealth ReportProfileFEV₁ gauge + live metricsTrend charts (Today/Weekly/Monthly)AI-assisted doctor chatAuto-generated health summaryPatient & clinician profile

Features

Custom FEV₁ Gauge — Circular arc canvas drawn from scratch using Jetpack Compose Canvas, no third-party charting library
ML Risk Clustering — K-Means model classifies daily spirometry into 4 risk levels: Normal, Mild, Moderate, Severe
Trend Charts — Fully custom line + bar chart built with Canvas, animated tab switching between Today / Weekly / Monthly views
Care Chat — Structured async messaging between patient and care provider
Health Report Generator — Auto-summarizes lung health, vitals, and doctor notes into a shareable report
Authentication Flow — Sign In and Create Account screens with form validation


Tech Stack

Language: Kotlin 100%
UI Framework: Jetpack Compose
Architecture: Screen-based navigation with NavController
ML: K-Means clustering (trained offline in Python, cluster centers encoded on-device)
Design: Custom beige-brown palette (sand / almond / cocoa), 48dp tap targets, thumb-zone optimized layout


Project Structure
PulmoGuardUI/
└── app/src/main/java/
    ├── com/example/pulmoguardui/
    │   ├── MainActivity.kt
    │   ├── SignInActivity.kt
    │   ├── CreateAccountActivity.kt
    │   └── HomeActivity.kt
    └── ui/
        ├── screens/
        │   ├── VitalScreen.kt       # FEV₁ gauge + metric cards
        │   ├── InsightScreen.kt     # Custom trend chart
        │   ├── CareChatScreen.kt    # Doctor chat UI
        │   ├── HealthReport.kt      # Generated report screen
        │   └── ProfileScreen.kt     # Patient profile
        ├── navigation/
        │   ├── HomeNavGraph.kt
        │   └── Screen.kt
        ├── home/HomeScaffold.kt
        ├── components/PulmoGuardTextField.kt
        └── theme/
            ├── color.kt
            ├── theme.kt
            └── type.kt

 ML Pipeline
Daily spirometry inputs (FEV₁, FVC, FEV₁/FVC ratio, peak flow) are normalized and mapped to one of 4 risk clusters using K-Means centers exported from an offline Python model. The Vitals screen displays the resulting risk label in real time.
Risk Clusters:

Cluster 0 — Normal
Cluster 1 — Mild Risk
Cluster 2 — Moderate Risk
Cluster 3 — Severe Risk (triggers care team alert)


📋 Clinical Context
COPD exacerbations cost $10,000–15,000 per hospitalization. PulmoGuard aims to detect deterioration 3–7 days in advance, enabling timely pulmonary rehabilitation with an evidence-based NNT of 4–6 to prevent rehospitalization.
