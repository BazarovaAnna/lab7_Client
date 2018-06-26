# lab7_Client
Доработать программу из лабораторной работы №6 следующим образом: 
1. Хранящимся в коллекции объектам добавить характеристику цвета.
2. Написать графический интерфейс для серверной части, который в центральной части окна отображает элементы коллекции с помощью JTree, реализует функции добавления, редактирования и удаления объекта, а также все остальные функции для управления коллекцией из предыдущей работы. Интерфейс должен удовлетворять следующим требованиям:
должна осуществляться авторизация пользователя с помощью пароля;
операции чтения и сохранения коллекции объектов должны быть реализованы как пункты меню;
элементы управления объектами должны располагаться в нижней части окна;
для расстановки объектов управления необходимо использовать BoxLayout.
3. Написать графический интерфейс для клиентской части, который отображает в окне объекты коллекции в виде кругов соответствующего размера и цвета, расположенных согласно своим координатам. Интерфейс должен удовлетворять следующим требованиям:
при наведении мышкой на объект должна появляться всплывающая подсказка с именем объекта;
должны быть реализованы фильтры для каждой характеристики объектов;
при реализации фильтров должны быть использованы JCheckBox, JTextField, JSlider и другие компоненты;
при нажатии на кнопку "Старт" объекты, характеристики которых соответствуют текущим значениям фильтров, должны в течение 2 секунд плавно уменьшать размер в 2 раза, затем в течение 4 секунд возвращаться в исходное состояние;
при нажатии на кнопку "Стоп" анимация должна останавливаться.
4. Графические интерфейсы реализуются с помощью библиотеки Swing. По согласованию с преподавателем библиотека может быть изменена.

Доработать программу из лабораторной работы №7 следующим образом:
В класс, объекты которого хранятся в коллекции, добавить поле типа java.time.LocalDateTime, в котором должны храниться дата и время создания объекта.
Графический интерфейс клиентской части должен поддерживать русский, румынский, шведский и английский (Соединенное Королевство) языки / локали. Должно обеспечиваться корректное отображение чисел, даты и времени в соответстии с локалью. Переключение языков должно происходить без перезапуска приложения. Локализованные ресурсы должны храниться в файле свойств. Сортировку и фильтрацию значений столбцов реализовать с помощью Streams API.
Сервер должен обеспечивать простейшую реализацию объектно-реляционного отображения с использованием рефлексии, в том числе создание таблицы базы данных в соответствии с полями объекта и CRUD-запросы. 
