import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import './App.css';
import routePublic from './route/routes';
import DefaultLayout from './layout/DefaultLayout';
import { Fragment } from 'react';


function App() {
  return (
    <Router>
        <div className="App">
      <Routes>
          {routePublic.map((route, index) => {
            let Layout = DefaultLayout;
            if (route.Layout) {
              Layout = route.Layout;
            } else if (route.Layout === null) {
              Layout = Fragment;
            }

            const Page = route.component;
            return (
              <Route
                key={index}
                path={route.path}
                element={
                  <Layout>
                    <Page />
                  </Layout>
                }
              />
            )
          })}
      </Routes>
        </div>
    </Router>
  );
}

export default App;
