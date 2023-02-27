import SwiftUI
import SharedSDK

@main
struct iOSApp: App {
    
    init() {
        PlatformSDK().doInit(config: PlatformConfiguration())
    }
    
    var body: some Scene {
        WindowGroup {
            ContentView()
        }
    }
}
