## ok-202105-orchestrator-pg
Оркестратор, Гасанов Паша

# Цель проекта
Предоставить инструментарий управления и слежения за распределенными серверами.
Предоставить возможность управления на распределеных серверах проектов (сущность формирующаяся на основе docker-compose фала).

Пример:
Есть несколько распределенных серверов на которые необходимо разместить несколько проектов.
Система дожна распределить проекты по указанным хостам в зависимости от мощности хостов, а так же требований самого проекта.
На сервере можеть быть несколько проектов. Проект не может быть на нескольких серверах(теоретически ситуация возможна).

# Задачи проекта
* Мониторинг хостов.
* Мониторинг запущенных проектов.
* Сбор различных логов.
* Оповещение в случае возникновения проблем.
* Web интерфейс необходимо организовать в качестве chatops.

# Инструменты
* ssh - для управления/мониторинга хостов.
* git-репозиторий/форма для заполнения - для формирования проектов.
* Web интерфейс для мониторинга/упралвения

# Дальнейшее развитие...
* Различная интеграция в системах обмена сообщенями
* Использование агента непосредственно на хосте, вместо ssh
* Создание базы знаний на основе сообщений chatops
