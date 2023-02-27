import SwiftUI
import SharedSDK

struct ContentView: View {
	//let greet = Greeting().greet()
    
    private let vm = LoginViewModel()

	var body: some View {
        Button{
            vm.obtainEvent(viewEvent: .LoginClick())
        } label: {
            Text("Click")
        }
      
	}
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}
