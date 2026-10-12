import SwiftUI

struct SelectFaceMatcherDialog: View {
    let choices: [String]
    @Binding var selected: String
    let onDismissed: () -> Void

    var body: some View {
        ZStack {
            Color.black.opacity(0.4)
                .ignoresSafeArea()
                .onTapGesture {
                    onDismissed()
                }

            VStack(alignment: .leading, spacing: 20) {
                Text("Select face matcher")
                    .font(.title3.bold())
                    .foregroundColor(.primary)

                VStack(alignment: .leading, spacing: 16) {
                    ForEach(choices, id: \.self) { choice in
                        let isSelected = (choice == selected)
                        Button {
                            selected = choice
                        } label: {
                            HStack(alignment: .top, spacing: 14) {
                                ZStack {
                                    Circle()
                                        .stroke(isSelected ? Color.accentColor : Color.secondary.opacity(0.5), lineWidth: 2)
                                        .frame(width: 20, height: 20)
                                    if isSelected {
                                        Circle()
                                            .fill(Color.accentColor)
                                            .frame(width: 10, height: 10)
                                    }
                                }
                                .padding(.top, 2)

                                VStack(alignment: .leading, spacing: 4) {
                                    Text(choice)
                                        .font(.body)
                                        .foregroundColor(.primary)

                                    if let blurb = blurbForChoice(choice) {
                                        Text(blurb)
                                            .font(.subheadline)
                                            .foregroundColor(.secondary)
                                            .multilineTextAlignment(.leading)
                                    }
                                }
                                Spacer()
                            }
                            .contentShape(Rectangle())
                        }
                        .buttonStyle(.plain)
                    }
                }

                Button {
                    onDismissed()
                } label: {
                    Text("Close")
                        .font(.headline)
                        .frame(maxWidth: .infinity)
                        .padding(.vertical, 12)
                        .foregroundColor(.primary)
                        .background(Color(uiColor: .secondarySystemBackground))
                        .cornerRadius(12)
                }
                .padding(.top, 4)
            }
            .padding(24)
            .background(
                RoundedRectangle(cornerRadius: 24)
                    .fill(Color(uiColor: .systemBackground))
                    .shadow(color: Color.black.opacity(0.15), radius: 24, x: 0, y: 8)
            )
            .padding(.horizontal, 24)
        }
        .frame(maxWidth: .infinity, maxHeight: .infinity)
        .ignoresSafeArea()
    }

    private func blurbForChoice(_ choice: String) -> String? {
        switch choice {
        case "MobileFaceNet":
            return "Intended only for development and testing and does not provide biometric security guarantees."
        case "MobileFaceNet (debug)":
            return "Includes a debug option to bypass verification. Intended only for development and testing and does not provide biometric security guarantees."
        case "None":
            return "Disables face matching during credential presentation."
        default:
            return nil
        }
    }
}
