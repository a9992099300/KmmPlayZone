//
//  CommonTextField.swift
//  iosApp
//
//  Created by Alex on 27.02.2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI

struct CommonTextField: View {
    
   
    
    @State private var value: String = ""
    private let hint: String
    private let enabled: Bool
    private let isSecure: Bool
    private let onValueChanged: (String) -> Void
    
    init(hint: String, enabled: Bool = true, isSecure: Bool = false, onValueChanged: @escaping (String) -> Void
    ) {
        self.hint = hint
        self.enabled = enabled
        self.isSecure = isSecure
        self.onValueChanged = onValueChanged
    }
    
    var body: some View {
        ZStack(alignment: .center){
            RoundedRectangle(cornerRadius: 10)
                .foregroundColor(.backgroundSecondary)
            
            if (value.isEmpty) {
                Text(hint)
                    .foregroundColor(Color.textPrimary.opacity(0.5))
                    .padding(EdgeInsets(top: 0, leading: 20, bottom: 0, trailing: 20))
                    .font(.system(size: 16))
            }
            
            if isSecure {
                SecureField(value, text: $value)
                    .foregroundColor(.textPrimary)
                    .font(.system(size: 16))
                    .autocapitalization(.none)
                    .disabled(!enabled)
                    .disableAutocorrection(true)
                    .padding(EdgeInsets(top: 0, leading: 20, bottom: 0, trailing: 20))
                    .onChange(of: value) { newValue in
                        onValueChanged(newValue)
                    }
            } else {
                TextField(value, text: $value)
                    .foregroundColor(.textPrimary)
                    .font(.system(size: 16))
                    .autocapitalization(.none)
                    .disabled(!enabled)
                    .disableAutocorrection(true)
                    .padding(EdgeInsets(top: 0, leading: 20, bottom: 0, trailing: 20))
                    .onChange(of: value) { newValue in
                        onValueChanged(newValue)
                    }
            }
            
        
            
        }
        .frame(height: 56)
        .padding(EdgeInsets(top: 0, leading: 24, bottom: 0, trailing: 24))
    }
}

struct CommonTextField_Previews: PreviewProvider {
    static var previews: some View {
        CommonTextField(hint: "Email you", enabled: true, isSecure: true, onValueChanged: { newValue in
            print(newValue)
        })
    }
}
