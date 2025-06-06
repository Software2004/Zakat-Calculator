# ☪️ Zakat Pro - Islamic Wealth Calculator

<div align="center">
  <img src="assets/app_icon.png" width="150" alt="App Icon" style="border-radius: 20px;">
  
  [![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)](https://java.com)
  [![Material Design](https://img.shields.io/badge/Material%20Design-757575?style=for-the-badge&logo=material-design)](https://material.io)

</div>

## 🌙 Features

- **Gold/Silver Calculator** (Nisab thresholds)
- **Cash & Savings** evaluation
- **Business Assets** assessment  
- **Agricultural Zakat** mode
- **Islamic Date Integration** (Hijri calendar)

## 🕌 Screenshots

<div align="center">
  <img src="screenshots/main.jpg" width="24%" alt="Main Screen">
  <img src="screenshots/gold.jpg" width="24%" alt="Gold Calculation"> 
  <img src="screenshots/results.jpg" width="24%" alt="Results">
  <img src="screenshots/hijri.jpg" width="24%" alt="Hijri Date">
</div>

## 📿 Calculation Logic

```java
public BigDecimal calculateZakat(BigDecimal wealth, BigDecimal nisab) {
    return wealth.compareTo(nisab) >= 0 ? 
           wealth.multiply(new BigDecimal("0.025")) : 
           BigDecimal.ZERO;
}

// Gold Nisab (87.48g as of 2023)
public boolean meetsNisab(BigDecimal goldGrams) {
    return goldGrams.compareTo(new BigDecimal("87.48")) >= 0;
}
