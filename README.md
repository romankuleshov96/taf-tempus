# Автоматизированный фреймворк для тестирования веб-сайта [tempus.by](https://tempus.by/)
TEMPUS – СОВРЕМЕННЫЙ ЧАСОВОЙ РИТЕЙЛЕР НАРУЧНЫХ ЧАСОВ.

___

## Содержание:

- [Используемый стек](#computer-используемый-стек)
- [Список проверок](#spiral_notepad-список-проверок)
- [Запуск автотестов в Jenkins](#-запуск-автотестов-в-jenkins)
- [Пример Allure-отчета](#-пример-allure-отчета)
- [Уведомления в Slack](#-уведомления-в-slack)


___

## 💻 Используемый стек

| <a href="https://www.jetbrains.com/idea/"><img src="https://www.svgrepo.com/show/353906/intellij-idea.svg" width="40" height="40"  alt="IDEA"/></a> | <a href="https://www.java.com/"><img src="https://www.svgrepo.com/show/303388/java-4-logo.svg" width="40" height="40"  alt="Java"/></a> | <a href="https://junit.org/"><img src="https://logo.svgcdn.com/d/junit-original-wordmark.svg" width="40" height="40"  alt="JUnit 5"/></a> | <a href="https://maven.apache.org/"><img src="https://www.svgrepo.com/show/354051/maven.svg" width="40" height="40"  alt="Maven"/></a> | <a href="https://www.selenium.dev/"><img src="https://www.svgrepo.com/show/354321/selenium.svg" width="40" height="40"  alt="Selenium"/></a> | <a href="https://rest-assured.io/"><img src="https://unicodetechnologies.in/assets/images/courses/rest-assured.png" width="40" height="40"  alt="Selenide"/></a> |
|:-------------------------------------------------------------------------------------------------------------------------:|:-----------------------------------------------------------------------------------------------------------------:|:----------------------------------------------------------------------------------------------------------------------:|:---------------------------------------------------------------------------------------------------------------------------------------:|:---------------------------------------------------------------------------------------------------------------:|:---------------------------------------------------------------------------------------------------------------------:|
|                                                           IDEA                                                            |                                                       Java                                                        |                                                         Junit5                                                         |                                                                  Maven                                                                  |                                                    Selenium                                                     |                                                     Rest-assured                                                      |

| <a href="https://www.jenkins.io/"><img src="https://www.svgrepo.com/show/353929/jenkins.svg" width="40" height="40"  alt="Jenkins"/></a> |<a href="https://allurereport.org/"><img src="https://avatars.githubusercontent.com/u/5879127?s=200&v=4" width="40" height="40"  alt="Allure"/></a>                 | <a href="http://github.com/home"><img src="https://github.githubassets.com/assets/GitHub-Mark-ea2971cee799.png" width="40" height="40"  alt="Github"/></a> | <a href="https://slack.com/"><img src="https://www.svgrepo.com/show/303320/slack-new-logo-logo.svg" width="40" height="40"  alt="Slack"/></a> |
|:---------------------------------------------------------------------------------------------------------------------------------------------------------:|:-----------------------------------------------------------------------------------------------------------------------------------------------------------:|:-----------------------------------------------------------------------------------------------------------------------:|:---------------------------------------------------------------------------------------------------------------------:|
|                                                                         Jenkins                                                                          |                                                                           Allure                                                                            |                                                        Github                                                         |                                                         Slack                                                         |

- Тесты в данном проекте написаны на языке <code>Java</code> и разработаны в среде разработки <code>IDEA</code>
- Для UI тестов при написании использовалась библиотека для тестирования <code>Selenium</code>
- Для API тестов при написании использовалась библиотеке для тестирования <code>Rest-assured</code>
- В качестве сборщика был использован <code>Maven</code>
- <code>JUnit 5</code> задействован в качестве фреймворка модульного тестирования
- Для удаленного запуска реализована джоба в <code>Jenkins</code> с формированием <code>Allure-отчета</code> и отправкой результатов в <code>Slack</code> при помощи бота

___

## 🗒️ Список проверок

### Web-тесты
✅ Тестирование формы 'Входа' - авторизация по почте и паролю  <br />
✅ Тестирование формы 'Регистрации' <br />
✅ Тестирование формы 'Восстановления пароля'<br />
✅ Проверка страницы 'Бренды' - выбор бренда - дальнейшее отображение продуктов определенного бренда<br />
✅ Проверка выбора определенного Продукта (Бренд, название модели) <br />
✅ Проверка функциональности добавления продукта в корзину <br />

### Api-тесты
✅ Проверка статус кода и валидационных сообщений в response для следующих запросов: <br />
✅ Аутентификация <br />
✅ Регистрация пользователя <br />
✅ Восстановление пароля<br />

---
## <img width="4%" style="vertical-align:middle" title="Jenkins" src="https://www.svgrepo.com/show/353929/jenkins.svg"> Запуск автотестов в Jenkins

Для автоматического запуска тестов, в Jenkins реализована job'a, использующаяя cron expression - запуск каждый будний день в 9 утра.

Реализована интеграция с Allure report, внутри Jenkins.

<img width="140%" style="vertical-align:middle" title="Slack" src="https://i.postimg.cc/fbrHvb0M/2025-07-22-20-32-39.png">

---

## <img width="4%" style="vertical-align:middle" title="Allure Report" src="https://avatars.githubusercontent.com/u/5879127?s=200&v=4"> Пример Allure-отчета

### <a target="_blank" href="http://localhost:8080/job/Tempus.by/3/allure/">Пример</a> отчёта выполнения одного из автотестов

<img width="140%" style="vertical-align:middle" title="Allure Report" src="https://i.postimg.cc/Jz83fjQ0/2025-07-22-19-01-39.png">

<img width="140%" style="vertical-align:middle" title="Allure Report" src="https://i.postimg.cc/FKWjk8Xk/2025-07-22-19-01-24.png">

Содержит в себе:
- Информацию о количестве запущенный тестов
- Время выполнения
- Статус
- Логи браузерной консоли
- Процентное соотношение успешно выполненных тестов

___

## <img width="4%" style="vertical-align:middle" title="Slack" src="https://www.svgrepo.com/show/303320/slack-new-logo-logo.svg"> Уведомления в Slack

### После завершения сборки, бот, созданный в <code>Slack</code>, автоматически обрабатывает и отправляет сообщение с результатом

<img width="140%" style="vertical-align:middle" title="Slack" src="https://i.postimg.cc/QCMwkRFL/2025-07-22-19-06-42.png">
<img width="140%" style="vertical-align:middle" title="Slack" src="https://i.postimg.cc/wBTPVPfQ/2025-07-22-20-31-10.png">