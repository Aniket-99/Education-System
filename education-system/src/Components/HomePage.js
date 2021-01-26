import React, { Component } from "react";
import "../css/demobootstrapportfoliowesite.css";
import mainbganimation1 from "../images/mainbganimation1.gif";
import elearninganimation from "../images/18365-animaton-for-e-learning-web-site.gif";
import learner from "../images/learner.svg";
import instructor from "../images/instructor.svg";
import administrator from "../images/administrator.svg";
import reactnative from "../images/hire-reactnative01.png";
import service1 from "../images/service01.png";
import e3 from "../images/e3.jpg";
import reactjs from "../images/ReactJS.png";
import logo from "../images/logoonly-removebg-preview.png";
import reactjsbanner from "../images/Reactjs-banner-img.png";
import { NavBarHome } from "./NavBarHome";

class HomePage extends Component {
  constructor(props) {
    super(props);
  }

  componentWillMount() {
    if (localStorage.getItem("loggedUser")) {
      this.props.history.replace("/student-home");
    }
    // else if(localStorage.getItem("loggedAdmin")){
    //   this.props.history.replace('/admin-home')
    // }
  }
  render() {
    return (
      <div>
        <NavBarHome />
        {/* <div className="hero">
          <section id="hero">
            <div className="container">
              <div className="row">
                <div className="col">
                  <img className="wave" src={mainbganimation1} />
                  <div className="name">
                    edu<span> crate</span>
                  </div>
                  <p className="tagline">
                    The Purpose is to teach, bring learning to people
                  </p>
                  <p>
                    Lorem ipsum dolor, sit amet consectetur adipisicing elit.
                    Repudiandae fugit consequuntur earum sit labore cumque,
                    optio accusamus assumenda quas vitae eveniet nemo quaerat!.
                  </p>
                  <button
                    className="home-button"
                    type="button"
                    className="btn btn-dark btn-lg"
                  >
                    <small>Learn More</small>
                  </button>
                </div>
                <div className="col img-col">
                  <img
                    src={elearninganimation}
                    alt="Online Learning"
                    className="img-fluid"
                  />
                </div>
              </div>
              <div className="row cards">
                <div className="col-md-4 d-flex justify-contents">
                  <div className="card" style={{ width: "18rem" }}>
                    <div className="card-body">
                      <img src={learner} alt="learner" className="icon" />
                      <h5 className="card-title">learner</h5>
                      <p className="card-text">
                        Some quick example text to build on the card title and
                        make up the bulk of the card's content.
                      </p>
                    </div>
                  </div>
                </div>
                <div className="col-md-4 d-flex justify-contents">
                  <div className="card" style={{ width: "18rem" }}>
                    <div className="card-body">
                      <img src={instructor} alt="instructor" className="icon" />
                      <h5 className="card-title">instructor</h5>
                      <p className="card-text">
                        Some quick example text to build on the card title and
                        make up the bulk of the card's content.
                      </p>
                    </div>
                  </div>
                </div>
                <div className="col-md-4 d-flex justify-contents">
                  <div className="card" style={{ width: "18rem" }}>
                    <div className="card-body">
                      <img
                        src={administrator}
                        alt="administrator"
                        className="icon"
                      />
                      <h5 className="card-title">administrator</h5>
                      <p className="card-text">
                        Some quick example text to build on the card title and
                        make up the bulk of the card's content.
                      </p>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </section>
        </div>

        <section id="about-us">
          <div className="container">
            <div className="row align-items-center">
              <div className="col">
                <img src={reactnative} alt="" className="img-fluid" />
              </div>
              <div className="col">
                <h1>About Us</h1>
                <h6>
                  "Learning is not attained by chance, it must be sought with
                  ardor and attended to with diligence." ---Abigail Adams
                </h6>
                <p>
                  Lorem ipsum dolor, sit amet consectetur adipisicing elit.
                  Repudiandae fugit consequuntur earum sit labore cumque, optio
                  accusamus assumenda quas vitae eveniet nemo quaerat! Quod ea
                  porro reprehenderit, quia veritatis dolorem.
                </p>
                <button
                  className="home-button"
                  type="button"
                  className="btn btn-dark btn-lg"
                >
                  <small>Meet Us</small>
                </button>
              </div>
            </div>
          </div>
        </section>

        <section id="courses">
          <div className="container">
            <div className="row align-items-center courses">
              <div className="col">
                <h1>Our Courses</h1>
                <p>
                  Lorem ipsum dolor, sit amet consectetur adipisicing elit.
                  Repudiandae fugit consequuntur earum sit labore cumque, optio
                  accusamus assumenda quas vitae eveniet nemo quaerat! Quod ea
                  porro reprehenderit, quia veritatis dolorem.
                </p>
              </div>
            </div>

            <div className="row align-items-center">
              <div className="col">
                <div className="card mb-3">
                  <img src={service1} className="card-img-top" alt="..." />
                  <div className="card-body">
                    <h5 className="card-title">React VR</h5>
                    <p className="card-text">
                      This is a wider card with supporting text below as a
                      natural lead-in to additional content. This content is a
                      little bit longer.
                    </p>
                    <p className="card-text">
                      <small className="text-muted">Course 1</small>
                    </p>
                  </div>
                </div>
              </div>

              <div className="col">
                <div className="card mb-3">
                  <img src={reactnative} className="card-img-top" alt="..." />
                  <div className="card-body">
                    <h5 className="card-title">HTML and CSS</h5>
                    <p className="card-text">
                      This is a wider card with supporting text below as a
                      natural lead-in to additional content. This content is a
                      little bit longer.
                    </p>
                    <p className="card-text">
                      <small className="text-muted">Course 2</small>
                    </p>
                  </div>
                </div>
              </div>
            </div>

            <div className="row align-items-center">
              <div className="col">
                <div className="card mb-3">
                  <img src={reactjs} className="card-img-top" alt="..." />
                  <div className="card-body">
                    <h5 className="card-title">React Js</h5>
                    <p className="card-text">
                      This is a wider card with supporting text below as a
                      natural lead-in to additional content. This content is a
                      little bit longer.
                    </p>
                    <p className="card-text">
                      <small className="text-muted">Course 3</small>
                    </p>
                  </div>
                </div>
              </div>

              <div className="col">
                <div className="card mb-3">
                  <img src={reactjsbanner} className="card-img-top" alt="..." />
                  <div className="card-body">
                    <h5 className="card-title">React Native</h5>
                    <p className="card-text">
                      This is a wider card with supporting text below as a
                      natural lead-in to additional content. This content is a
                      little bit longer.
                    </p>
                    <p className="card-text">
                      <small className="text-muted">Course 3</small>
                    </p>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </section>

        <section id="contact">
          <div className="container">
            <div className="row">
              <div className="col">
                <h1>CONTACT US</h1>
                <p>
                  Lorem ipsum dolor, sit amet consectetur adipisicing elit.
                  Repudiandae fugit consequuntur earum sit labore cumque, optio
                  accusamus assumenda quas vitae eveniet nemo quaerat! Quod ea
                  porro reprehenderit, quia veritatis dolorem.
                </p>
              </div>
            </div>
          </div>
        </section> */}

        <div class="hero">
          <section id="hero">
            <div class="container">
              <div class="row">
                <div class="col">
                  <img class="wave" src={mainbganimation1} />
                  <div class="name">
                    edu<span> crate</span>
                  </div>
                  <p class="tagline">
                    The Purpose is to teach, bring learning to people
                  </p>
                  <p>
                    <b style={{ fontSize: "large" }}>
                      Transform your career through education and change the
                      world by learning restless. Explore critical skills for
                      the year ahead. Courses start at just 455INR. <br />
                    </b>
                  </p>
                </div>
                <div class="col img-col">
                  <img
                    src={elearninganimation}
                    alt="Online Learning"
                    class="img-fluid"
                  />
                </div>
              </div>
              <div class="row cards">
                <div class="col-md-4 d-flex justify-contents">
                  <div class="card" style={{ width: "18rem" }}>
                    <div class="card-body">
                      <img src={learner} alt="learner" class="icon" />
                      <h5 class="card-title">Learner</h5>
                      <p class="card-text">
                        Build your knowledge by exploring various courses.
                      </p>
                    </div>
                  </div>
                </div>
                <div class="col-md-4 d-flex justify-contents">
                  <div class="card" style={{ width: "18rem" }}>
                    <div class="card-body">
                      <img src={instructor} alt="instructor" class="icon" />
                      <h5 class="card-title">Instructor</h5>
                      <p class="card-text">
                        Connect with best trainers to gain knowledge.
                      </p>
                    </div>
                  </div>
                </div>
                <div class="col-md-4 d-flex justify-contents">
                  <div class="card" style={{ width: "18rem" }}>
                    <div class="card-body">
                      <img
                        src={administrator}
                        alt="administrator"
                        class="icon"
                      />
                      <h5 class="card-title">Administrator</h5>
                      <p class="card-text">
                        Drop your queries to admin and give feedback.
                      </p>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </section>
        </div>

        <section id="about-us">
          <div class="container">
            <div class="row align-items-center">
              <div class="col">
                <img src={reactnative} alt="" class="img-fluid" />
              </div>
              <div class="col">
                <h1>About Us</h1>
                <h6>
                  "Learning is not attained by chance, it must be sought with
                  ardor and attended to with diligence." ---Abigail Adams
                </h6>
                <p>
                  As a global nonprofit, we're relentlessly pursuing our vision
                  of a world where every learner can access education to unlock
                  their potential, without the barriers of cost or location..
                </p>
              </div>
            </div>
          </div>
        </section>

        <section id="courses">
          <div class="container" id="Courses">
            <div class="row align-items-center courses">
              <div class="col">
                <h1>Our Top Courses</h1>
              </div>
            </div>

            <div class="row align-items-center">
              <div class="col-md-4">
                <div class="card mb-3">
                  <img src={service1} class="card-img-top" alt="..." />
                  <div class="card-body">
                    <h5 class="card-title">React Native</h5>
                    <p class="card-text">
                      The complete React Native course ( 2021 edition ).
                    </p>
                    <div class="d-flex justify-content-between">
                      <p class="card-text">
                        <small class="text-muted">Course </small>
                      </p>
                      <h5 class="price">6,000INR.</h5>
                    </div>
                  </div>
                </div>
              </div>

              <div class="col-md-4">
                <div class="card mb-3">
                  <img src={e3} class="card-img-top" alt="..." />
                  <div class="card-body">
                    <h5 class="card-title">HTML and CSS</h5>
                    <p class="card-text">
                      Build Responsive Real World Websites with HTML5 and CSS3.
                    </p>
                    <div class="d-flex justify-content-between">
                      <p class="card-text">
                        <small class="text-muted">Course </small>
                      </p>
                      <h5 class="price">5,000INR.</h5>
                    </div>
                  </div>
                </div>
              </div>
              <div class="col-md-4">
                <div class="card mb-3">
                  <div class="ribbon">
                    <span class="ribbon-span">Bestseller</span>
                  </div>
                  <img src={reactjs} class="card-img-top" alt="..." />
                  <div class="card-body">
                    <h5 class="card-title">React JS</h5>
                    <p class="card-text">
                      The Complete Guide (incl Hooks, React Router, Redux).
                    </p>
                    <div class="d-flex justify-content-between">
                      <p class="card-text">
                        <small class="text-muted">Course </small>
                      </p>
                      <h5 class="price">7,000INR.</h5>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </section>

        <section id="contact">
          <div class="container-fluid">
            <div class="row">
              <div class="col">
                <div class="icon">
                  <i
                    class="fa fa-twitter fa-3x"
                    style={{ color: "lightblue" }}
                  ></i>
                  <i
                    class="fa fa-instagram fa-3x"
                    style={{ color: "rgb(250, 93, 93)" }}
                  ></i>
                  <i
                    class="fa fa-facebook fa-3x"
                    style="color: rgb(99, 99, 206);"
                    style={{ color: "rgb(99, 99, 206)" }}
                  ></i>
                </div>
                <h1>Connect With US</h1>
                <p>
                  Top companies choose Educrate for Business to build in-demand
                  career skills..
                </p>
                <div class="div d-flex justify-content-between">
                  <div class="left">
                    <img class="logo" src={logo} />{" "}
                    <b>
                      <large>EDUCRATE</large>
                    </b>
                  </div>
                  <p class="right">© 2021 Educrate, Inc. </p>
                </div>
              </div>
            </div>
          </div>
        </section>
      </div>
    );
  }
}

export default HomePage;
