В описании задания было использован тип float для цен и прочего, было решено заменить на BigDecimal для более точных вычислений.

Можно было бы улучшить систему методами валидациями для проверки товаров.

В будущем можно связать решения для кэширования с Redis.

Так же стоило бы уточнить информацию о типе оплаты, не будет ли влияния на на подсчет стоимости корзины.

Было бы неплохо применить многопоточность для более быстрой работы.

Так же при получении цены из внешнего сервиса результат оборачивается в Optional с целью исключить случай неудачи при получении данных.

