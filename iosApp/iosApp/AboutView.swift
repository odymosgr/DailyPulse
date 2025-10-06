//
//  AboutView.swift
//  iosApp
//
//  Created by Odysseas Moschidis on 7/10/25.
//

import SwiftUI

struct AboutScreen: View {
    var body: some View {
      NavigationStack {
        AboutListView()
          .navigationTitle("About Device")
      }
    }
}

#Preview {
    AboutScreen()
}
