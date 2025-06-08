# ☪️ Zakat Pro - Islamic Wealth Calculator

<div align="center">
  
  <a href="https://youtu.be/I5P0-5j7WP8" target="_blank">
  <img src="https://img.shields.io/badge/YouTube_Short-FF0000?style=for-the-badge&logo=youtube&logoColor=white" height="28" align="center"></a><br><br>

  
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
  <img src="https://drive.google.com/uc?export=view&id=1NyXU_uJh-0i9qm8yMsg2QvyCI7ZVMYJt" width="22%" alt="Main Screen">
  <img src="https://drive.google.com/uc?export=view&id=1O-PYJVT88VGAuVc559hCzOSvbIkTd6UN" width="22%" alt="Main Screen">
  <img src="https://drive.google.com/uc?export=view&id=1O00rDHDwjugRzocDAmHbkd8s9ZEHCN64" width="22%" alt="Main Screen">
  <img src="https://drive.google.com/uc?export=view&id=1O27cNqAxRZF9O7H1D2s5v4KranJ9IYla" width="22%" alt="Main Screen">
  
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
