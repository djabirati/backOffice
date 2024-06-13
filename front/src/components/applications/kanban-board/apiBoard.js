import React, { Fragment, useState } from 'react';
import { apitodoboard } from '../../../data/apiboard'
import Board, { moveCard } from '@asseinfo/react-kanban'
import { Card, CardHeader, CardBody, Button } from 'reactstrap'
import { API, Default, Add, Done, ToDo } from '../../../constant'

const ApiBoard = (props) => {

    const [board, setBoard] = useState(apitodoboard)

    const addDefaultboard = () => {
        board.columns.push({
            id: Date.now(),
            title: 'Done',
            cards: [
                {
                    id: board.columns.length + 2,
                    title: "Test Sidebar",
                    date: "24/7/20",
                    priority: "Argent",
                    img: require("../../../assets/images/user/3.jpg"),
                    company: "Themeforest, australia",
                    rate: "+5",
                    customer_img1: require("../../../assets/images/user/3.jpg"),
                    customer_img2: require("../../../assets/images/user/1.jpg"),
                    customer_img3: require("../../../assets/images/user/5.jpg"),
                },
                {
                    id: board.columns.length + 3,
                    title: "Test Sidebar",
                    date: "24/7/20",
                    priority: "Argent",
                    backgroundImg: require("../../../assets/images/other-images/maintenance-bg.jpg"),
                    img: require("../../../assets/images/user/3.jpg"),
                    company: "Pixelstrap, New york",
                    rate: "+5",
                    customer_img1: require("../../../assets/images/user/3.jpg"),
                    customer_img2: require("../../../assets/images/user/1.jpg"),
                    customer_img3: require("../../../assets/images/user/5.jpg"),
                }
            ]
        })
        setBoard({ ...board })
    }

    const AddElementIntoTodo = () => {
        const index = board.columns.findIndex(x => x.title === "Todo");
        board.columns.map(elm => {
            if (index === 0 && elm.title === "Todo") {
                return {
                    ...elm,
                    ...elm.cards.push({
                        id: Date.now(),
                        title: "Test Sidebar",
                        date: "24/7/20",
                        priority: "Argent",
                        img: require("../../../assets/images/user/3.jpg"),
                        company: "Pixelstrap, New york",
                        rate: "+5",
                        customer_img1: require("../../../assets/images/user/3.jpg"),
                        customer_img2: require("../../../assets/images/user/1.jpg"),
                        customer_img3: require("../../../assets/images/user/5.jpg"),
                    })
                }
            }
            return elm
        })
        setBoard({ ...board })

    }
    const removeDoneboard = () => {
        const index = board.columns.findIndex(x => x.title === "Done");
        if (index === 2) {
            board.columns.splice(index, 1);
            setBoard({ ...board })
        }
    }
    function handleCardMove(_card, source, destination) {
        const updatedBoard = moveCard(board, source, destination);
        setBoard(updatedBoard);
    }
    return (
        <Fragment>
            <Card >
                <CardHeader>
                    <h5>{API}</h5>
                    <p className="mb-0">{" add item, add board, delete board: "}</p>
                </CardHeader>
                <CardBody>
                    <div id="demo3">
                        <div className="kanban-container">
                            <div className="kanban-board">
                                <main className="kanban-drag" id="addToDo">
                                    <Board onCardDragEnd={handleCardMove}
                                        renderCard={({ title, date, priority, backgroundImg, img, company, rate, customer_img1, customer_img2, customer_img3 }) => (
                                            <div className="kanban-item" id="todo">
                                                <a className="kanban-box" href="#javascript">
                                                    <span className="date">{date}</span>
                                                    <span className={`badge ${priority === "Argent" ? "badge-danger" : "badge-primary"} f-right`}>{priority}</span>
                                                    <img className="mt-2 img-fluid" src='' alt="" />
                                                    <h6>{title}</h6>
                                                    <div className="d-flex align-items-center">
                                                        <img className="img-20 me-1 rounded-circle" src={img} alt="" />
                                                        <div className="flex-grow-1">
                                                            <p>{company}</p>
                                                        </div>
                                                    </div>
                                                    <div className="d-flex mt-3">
                                                        <ul className="list">
                                                            <li><i className="fa fa-comments-o"></i>2</li>
                                                            <li><i className="fa fa-paperclip"></i>2</li>
                                                            <li><i className="fa fa-eye"></i></li>
                                                        </ul>
                                                        <div className="customers">
                                                            <ul>
                                                                <li className="d-inline-block me-3">
                                                                    <p className="f-12">{rate}</p>
                                                                </li>
                                                                <li className="d-inline-block"><img className="img-20 rounded-circle" src={customer_img1} alt="" /></li>
                                                                <li className="d-inline-block"><img className="img-20 rounded-circle" src={customer_img2} alt="" /></li>
                                                                <li className="d-inline-block"><img className="img-20 rounded-circle" src={customer_img3} alt="" /></li>
                                                            </ul>
                                                        </div>
                                                    </div>
                                                </a>
                                            </div>
                                        )}
                                        disableColumnDrag >
                                        {board}
                                    </Board>
                                </main>
                            </div>
                        </div>
                    </div>
                    <div className="mt-3">
                        <Button color="success" onClick={addDefaultboard}>{Add} &quot;{Default}&quot; {"board"}</Button>
                        <Button color="success" className="ms-1" onClick={AddElementIntoTodo}>{"Add element in"} &quot;{ToDo}&quot; {"Board"}</Button>
                        <Button color="danger" className="ms-1" onClick={removeDoneboard}>{"Remove"} &quot;{Done}&quot; {"Board"}</Button>
                    </div>
                </CardBody>
            </Card>
            <div id="mydata"></div>
        </Fragment >
    );
}

export default ApiBoard;