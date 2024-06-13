import React, { Fragment } from 'react';
import { VerticalTimeline, VerticalTimelineElement } from 'react-vertical-timeline-component';
import { Edit, Video, Image, Activity } from 'react-feather';
import 'react-vertical-timeline-component/style.min.css';

const Timeline1 = () => {
    return (
        <Fragment>
            <VerticalTimeline>
                    <VerticalTimelineElement
                        className="vertical-timeline-element--work"
                        animate={true}
                        date="2022 - present"
                        icon={<Edit />}
                    >
                        <h4 className="vertical-timeline-element-subtitle">{"Miami, FL"}</h4>
                        <p>
                            {"Creative Direction, User Experience, Visual Design, Project Management, Team Leading"}
                        </p>
                    </VerticalTimelineElement>
                    <VerticalTimelineElement
                        className="vertical-timeline-element--work"
                        date="2020 - 2021"
                        icon={<Video />}
                    >
                        <h4 className="vertical-timeline-element-subtitle">{"San Francisco, CA"}</h4>
                        <div className="embed-responsive embed-responsive-21by9 m-t-20">
                            <iframe src="https://www.youtube.com/embed/wpmHZspl4EM" allowFullScreen title="vertical-timeline" />
                        </div>
                    </VerticalTimelineElement>
                    <VerticalTimelineElement
                        className="vertical-timeline-element--work"
                        date="2016 - 2018"
                        animate={true}
                        icon={<Image />}
                    >
                        <h4 className="vertical-timeline-element-subtitle">{"Los Angeles, CA"}</h4>
                        <img className="img-fluid p-t-20" src={require("../../assets/images/banner/1.jpg")} alt="timelineImg1" />
                    </VerticalTimelineElement>
                    <VerticalTimelineElement
                        className="vertical-timeline-element--work"
                        date="2015 - 2017"
                        animate={true}
                        icon={<Activity />}
                    >
                        <h4 className="vertical-timeline-element-subtitle">{"San Francisco, CA"}</h4>
                        <audio controls preload="none">
                            <source  src={require("../../assets/audio/horse.ogg")} type="audio/ogg" />
                            {"Your browser does not support the audio element."}
                        </audio>
                    </VerticalTimelineElement>
                    <VerticalTimelineElement
                        className="vertical-timeline-element--education"
                        date="April 2019"
                        animate={true}
                        icon={<Image />}
                    >
                        <h4 className="vertical-timeline-element-subtitle">{"Online Course"}</h4>
                        <img className="img-fluid p-t-20" src={require("../../assets/images/banner/3.jpg")} alt="timelineImg2" />
                    </VerticalTimelineElement>
                    <VerticalTimelineElement
                        className="vertical-timeline-element--education"
                        date="November 2018"
                        animate={true}
                        icon={<Edit />}
                    >
                    <h4 className="vertical-timeline-element-subtitle">{"Certification"}</h4>
                    <p>
                        {`Lorem ipsum dolor sit amet, consectetur adipisicing elit. Iusto, optio, dolorum provident
                        rerum aut hic quasi placeat iure tempora laudantium ipsa ad debitis unde? Iste voluptatibus minus
                        veritatis qui ut.`}
                    </p>
                </VerticalTimelineElement>
            </VerticalTimeline>
        </Fragment>
    );
};

export default Timeline1;