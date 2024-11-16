import { routeConfig } from "../config/routeConfig";
import AddStudent from "../pages/AddStudent";
import HomePage from "../pages/HomePage";
import StudentDetail from "../pages/StudentDetail";
import UpdateStudent from "../pages/UpdateStudent";

const routePublic = [
    {
        path: routeConfig.home,
        component: HomePage,
    },
    {
        path: routeConfig.detail,
        component: StudentDetail,
    },
    {
        path: routeConfig.addStudent,
        component: AddStudent,
    },
    {
        path: routeConfig.updateStudent,
        component: UpdateStudent,
    },

]

export default routePublic;