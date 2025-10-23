# Yandex Samokat API tests

## Технологии
| Компонент | Версия |
|---|---|
| Java | 11 |
| Maven | 3.9.x |
| JUnit | 4.13.2 |
| REST Assured | 5.5.6 |
| Allure | 2.29.1 |
| Jackson Databind | 2.17.2 |

## Проект
Набор автотестов API сервиса **Яндекс.Самокат**:
- Создание курьера;
- Логин курьера;
- Создание заказа;
- Список заказов.

Базовый URL: `(http://qa-scooter.praktikum-services.ru/)`

## Запуск тестов
```bash
mvn clean test
