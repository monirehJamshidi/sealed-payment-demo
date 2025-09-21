[🇬🇧 English](./README.md) | [🇩🇪 Deutsch](./README.de.md)

# فارسی 🇮🇷
## معرفی
این یک پروژه Spring Boot است که استفاده از کلاس‌های sealed در جاوا را نشان می‌دهد.
پروژه سه نوع پرداخت (کارت اعتباری، پی‌پال، کریپتو) را مدل‌سازی کرده و از طریق یک API آنها را پردازش می‌کند.

## تکنولوژی‌ها
- جاوا 21 (یا جاوا 17 با فعال‌سازی preview features)
- Spring Boot 3
- Maven

## نحوه اجرا
mvn spring-boot:run

## آدرس‌ها

- GET /payments/credit → شبیه‌سازی پرداخت با کارت اعتباری
- GET /payments/paypal → شبیه‌سازی پرداخت با پی‌پال
- GET /payments/crypto → شبیه‌سازی پرداخت با کیف پول کریپتو

# تعریف sealed
کلاس‌ها و اینترفیس‌های sealed در جاوا (از نسخه 17 به بعد) یک قابلیت جدید هستند که اجازه می‌دهند شما کنترل کنید چه کلاس‌ها یا اینترفیس‌هایی می‌توانند از آن‌ها ارث‌بری (inherit) یا آن‌ها را پیاده‌سازی (implement) کنند.

## چرا sealed؟
- برای محدود کردن ارث‌بری و داشتن یک سلسله‌مراتب مشخص و امن‌تر.
- کمک به Pattern Matching در switch (که در جاوا 21 به بلوغ رسید).

## مثال عملی (با class)
    public sealed class Shape
        permits Circle, Rectangle, Square {
    }

    public final class Circle extends Shape {
    }

    public final class Rectangle extends Shape {
    }

    public non-sealed class Square extends Shape {
    }



## مثال عملی (با اینترفیس)
    public sealed interface Vehicle
        permits Car, Truck, Bike {
    }

    public final class Car implements Vehicle {
    }

    public final class Truck implements Vehicle {
    }

    public non-sealed class Bike implements Vehicle {
    }


## توضیح کلیدواژه‌ها
1. sealed → یعنی این کلاس یا اینترفیس فقط توسط کلاس‌هایی که در بخش permits آمده‌اند قابل ارث‌بری است.
2. permits → لیست کلاس‌ها یا اینترفیس‌هایی که اجازه‌ی ارث‌بری دارند.
3. final → یعنی کلاس نهایی است و دیگر کسی نمی‌تواند از آن ارث‌بری کند.
4. non-sealed → یعنی کلاس محدودیت sealed بودن را برمی‌دارد و دوباره آزاد است تا دیگران از آن ارث‌بری کنند.


## استفاده در Pattern Matching
وقتی از sealed استفاده می‌کنید، کامپایلر مطمئن است که همه‌ی زیرکلاس‌ها مشخص هستند، پس می‌توان در switch به شکل ایمن از آن‌ها استفاده کرد:


    static String getType(Vehicle v) {

        return switch (v) {
            case Car c    -> "This is a car";
            case Truck t  -> "This is a truck";
            case Bike b   -> "This is a bike";
        };
    }

---

## ✨ تعریف Pattern Matching 
یعنی جاوا بهت اجازه می‌ده وقتی داری با instanceof یا switch کار می‌کنی، همزمان هم چک نوع (type check) انجام بدی و هم کست کردن (cast) رو به صورت خودکار انجام بده.

## 🔹 قبل از Pattern Matching
مثلاً می‌خوای بررسی کنی که آبجکت از نوع String هست یا نه:

    Object obj = "Hello Java";

    if (obj instanceof String) {
        String s = (String) obj; // نیاز به cast جداگانه
        System.out.println(s.toUpperCase());
    }
