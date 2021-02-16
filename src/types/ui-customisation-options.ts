export type UICustomisationOptions = {
  // Primary Button
  colorContentButtonPrimaryText?: string
  colorBackgroundButtonPrimary?: string
  colorBackgroundButtonPrimaryHover?: string
  colorBackgroundButtonPrimaryActive?: string
  colorBorderButtonPrimary?: string

  // Secondary Button
  colorContentButtonSecondaryText?: string
  colorBackgroundButtonSecondary?: string
  colorBackgroundButtonSecondaryHover?: string
  colorBackgroundButtonSecondaryActive?: string
  colorBorderButtonSecondary?: string

  // Applied to both Primary, Secondary Buttons
  borderRadiusButton?: string

  // Displays Primary, Secondary Button groups as individual blocks instead of inline
  buttonGroupVertical?: boolean

  // Document Type Option Button
  colorBorderDocTypeButton?: string
  colorBorderDocTypeButtonHover?: string
  colorBorderDocTypeButtonActive?: string

  // Close (modal) buttons
  colorBackgroundButtonBackIconActive?: string
  colorBackgroundButtonCloseIconHover?: string
  colorBackgroundButtonCloseIconActive?: string

  // Camera button
  colorBackgroundButtonCamera?: string
  colorBackgroundButtonCameraHover?: string
  colorBackgroundButtonCameraActive?: string
}
