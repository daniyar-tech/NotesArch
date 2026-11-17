# Privacy and Data Safety — NotesArch

## 1. Data storage

NotesArch uses Room Database to store notes locally on the user's device.

The note entity contains:

- Note ID
- Note title
- Note content
- Creation timestamp

The application manifest has `allowBackup="true"`. Android backup behavior should therefore be considered when preparing the final privacy disclosure.

## 2. Authentication

The current application uses demonstration authentication.

- Login is checked locally against predefined test credentials.
- No Firebase Authentication integration is implemented.
- No server-side account creation is implemented.
- Email and password are held temporarily in the authentication UI state and passed to the local login implementation.

The demonstration credentials must not be used as real user authentication.

## 3. Firebase services

The application includes the following Firebase SDKs:

### Firebase Analytics

Used for application analytics. Automatic data collection may be enabled by default. The exact collected data must be reviewed in the Firebase data disclosure documentation.

### Firebase Crashlytics

Used for crash diagnostics. The SDK may automatically collect crash reports, app state, device information and installation identifiers.

### Firebase Remote Config

Used to retrieve remote application settings and feature flags:

- `welcome_message`
- `new_feature_enabled`
- `maintenance_mode`

## 4. Data security

- Notes are stored locally using Room.
- Firebase SDK communications use encrypted network connections.
- No custom transmission of note contents to Firebase was identified during the source code review.
- Android backup is enabled and should be considered in the data handling assessment.

## 5. Google Play Data Safety

Before publication, the developer must verify the actual Firebase SDK data collection and complete the Google Play Data Safety declaration accurately.

The declaration must account for:

- Analytics data collected by Firebase Analytics.
- Crash diagnostics collected by Firebase Crashlytics.
- Device and installation information.
- Data processed by Firebase Remote Config.
- Android backup behavior.

## 6. Publication checklist

- [ ] Review Firebase data collection disclosures.
- [ ] Confirm Analytics and Crashlytics collection settings.
- [ ] Prepare a public privacy policy.
- [ ] Verify data retention and deletion behavior.
- [ ] Complete the Google Play Data Safety declaration.
- [ ] Verify the final release build.

## 7. Current limitations

This document describes the current source code and dependencies. It is not a completed legal privacy policy or a submitted Google Play Data Safety declaration.

Google Play publication and Pre-launch Report have not been performed.
